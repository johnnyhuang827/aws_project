package com.example.controller;

import com.example.ajax.AjaxResult;
import com.example.entity.Department;
import com.example.entity.Student;
import com.example.service.DepartmentService;
import com.example.service.StudentService;
import com.example.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/studentVo")
public class StudentVoController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/queryAll")
    public List<StudentVo> queryAll(){
        List<Student> studentList = studentService.queryAll();
        List<StudentVo> studentVoList = new LinkedList<>();
        for(Student s : studentList){
            String departmentName = departmentService.queryById(s.getStudentDepartmentId()).getDepartmentName();
            StudentVo studentVo = new StudentVo(s.getStudentId(), s.getStudentName(),s.getStudentBirthday(), departmentName);
            studentVoList.add(studentVo);
        }
        return studentVoList;
    }

    @GetMapping("/{id}")
    public StudentVo getInfo(@PathVariable Long id){
        Student s = studentService.selectStudentById(id);
        String departmentName = departmentService.queryById(s.getStudentDepartmentId()).getDepartmentName();
        return new StudentVo(s.getStudentId(), s.getStudentName(),s.getStudentBirthday(), departmentName);
    }

}
