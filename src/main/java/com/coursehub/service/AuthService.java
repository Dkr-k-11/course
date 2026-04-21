package com.coursehub.service;

import org.springframework.stereotype.Service;
import com.coursehub.repository.StudentRepository;
import com.coursehub.entity.Student;
import com.coursehub.exception.ResourceNotFoundException;

@Service
public class AuthService {

    private final StudentRepository repo;

    public AuthService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student register(Student s) {
        return repo.save(s);
    }

    public Student login(String email, String password) {
        Student s = repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!s.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return s;
    }
}