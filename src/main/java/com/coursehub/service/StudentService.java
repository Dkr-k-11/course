package com.coursehub.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.coursehub.entity.*;
import com.coursehub.repository.*;
import com.coursehub.exception.*;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student enroll(Long studentId, Long courseId) {
        Student s = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course c = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        s.getCourses().add(c);
        return studentRepo.save(s);
    }
}