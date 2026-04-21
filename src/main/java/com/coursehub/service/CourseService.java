package com.coursehub.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.coursehub.entity.Course;
import com.coursehub.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAll() {
        return repo.findAll();
    }

    public Course save(Course c) {
        return repo.save(c);
    }
}