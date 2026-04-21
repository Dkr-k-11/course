package com.coursehub.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.coursehub.service.CourseService;
import com.coursehub.entity.Course;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Course create(@RequestBody Course c) {
        return service.save(c);
    }
}