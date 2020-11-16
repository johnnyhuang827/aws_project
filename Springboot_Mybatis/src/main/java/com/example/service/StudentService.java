package com.example.service;

import com.example.entity.Student;

import java.util.List;


public interface StudentService {
    Student selectStudentById(Long id);


    int insertStudent(Student student);


    int deleteStudentById(int id);


    int updateStudent(Student student);

    List<Student> queryAll();
}
