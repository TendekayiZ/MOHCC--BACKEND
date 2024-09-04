package com.example.stndsbackend.controller;


import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.service.authService.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private AuthService authService;

    //Build Add Students Rest API
    @PostMapping("/SignUp")
    public String Signup(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Registration failed, please check your input";
        }

        else if (registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            RegisterRequest savedStudents = authService.signup(registerRequest);
            return "Registration successful";
        } else {
            return "Registration failed, please check your password";
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    }



