package com.example.controller;

import com.example.ajax.AjaxResult;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

        @Autowired
        private StudentService studentService;

        protected AjaxResult toAjax(int rows)
        {
            return rows > 0 ? AjaxResult.success() : AjaxResult.error();
        }

        /**
         * 查所有
         * @return
         */
        @RequestMapping("/queryAll")
        public List<Student> queryAll(){
                return studentService.queryAll();
        }

        /**
         * 查
         * @param id
         * @return
         */
        @GetMapping("/{id}")
        public AjaxResult getInfo(@PathVariable Long id)
        {
            return AjaxResult.success(studentService.selectStudentById(id));
        }


        /**
         * 增
         * @param student
         * @return
         */
        @PostMapping
        public AjaxResult add(@Validated @RequestBody Student student)
        {
            return toAjax(studentService.insertStudent(student));
        }


        /**
         * 改
         * @param student
         * @return
         */
        @PutMapping
        public AjaxResult edit(@Validated @RequestBody Student student)
        {
            return toAjax(studentService.updateStudent(student));
        }


        /**
         * 删
         * @param id
         * @return
         */
        @DeleteMapping("/{id}")
        public AjaxResult remove( @PathVariable int id)
        {
            return toAjax(studentService.deleteStudentById(id));
        }

}


