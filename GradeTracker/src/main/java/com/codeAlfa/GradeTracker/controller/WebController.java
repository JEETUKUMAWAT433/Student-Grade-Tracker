package com.codeAlfa.GradeTracker.controller;

import com.codeAlfa.GradeTracker.model.Student;
import com.codeAlfa.GradeTracker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("newStudent", new Student());
        return "index";
    }

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/student/{id}")
    public String viewStudent(@PathVariable String id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "student";
    }

    @PostMapping("/student/{id}/grade/add")
    public String addGrade(@PathVariable String id, @RequestParam Double grade) {
        studentService.addGrade(id, grade);
        return "redirect:/student/" + id;
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
