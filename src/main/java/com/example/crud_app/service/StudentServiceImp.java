package com.example.crud_app.service;

import com.example.crud_app.model.Student;
import com.example.crud_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentById = studentRepository.findById(id);

        Student student = null;

        if (studentById.isPresent()) {
            student = studentById.get();
        } else {
            throw new RuntimeException("Student not found for id: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
