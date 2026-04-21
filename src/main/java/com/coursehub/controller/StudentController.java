package com.coursehub.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.coursehub.service.StudentService;
import com.coursehub.entity.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @PostMapping("/{id}/enroll/{courseId}")
    public Student enroll(@PathVariable Long id, @PathVariable Long courseId) {
        return service.enroll(id, courseId);
    }
}