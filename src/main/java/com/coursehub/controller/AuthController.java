package com.coursehub.controller;

import org.springframework.web.bind.annotation.*;
import com.coursehub.service.AuthService;
import com.coursehub.util.JwtUtil;
import com.coursehub.dto.AuthRequestDTO;
import com.coursehub.entity.Student;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService service;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public Student register(@RequestBody Student s) {
        return service.register(s);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDTO req) {
        Student s = service.login(req.email, req.password);
        return jwtUtil.generateToken(s.getEmail());
    }
}