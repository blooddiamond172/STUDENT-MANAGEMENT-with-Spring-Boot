package com.example.crud_app.service;

import com.example.crud_app.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
