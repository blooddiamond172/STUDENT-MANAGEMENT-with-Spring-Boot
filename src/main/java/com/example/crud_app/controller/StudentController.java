package com.example.crud_app.controller;

import com.example.crud_app.model.Student;
import com.example.crud_app.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping("/")
    public String getStudentList(Model model) {
        model.addAttribute("studentList", studentServiceImp.getAllStudents());
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentServiceImp.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id,
                                    Model model) {
        model.addAttribute("student", studentServiceImp.getStudentById(id));
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable(value = "id") Long id) {
        studentServiceImp.deleteStudent(id);
        return "redirect:/";
    }
}
