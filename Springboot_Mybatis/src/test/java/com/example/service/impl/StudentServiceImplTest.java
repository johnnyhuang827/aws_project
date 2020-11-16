package com.example.service.impl;

import com.example.entity.Student;
import com.example.service.StudentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void selectStudentById() {
        Student student = studentService.selectStudentById((long) 3);
        System.out.println(student);
    }

    @Test
    public void insertStudent() {
    }

    @Test
    public void deleteStudentById() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void queryAll() {
    }
}