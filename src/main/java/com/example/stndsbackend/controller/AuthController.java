package com.example.stndsbackend.controller;


import com.example.stndsbackend.common.LoginResponse;
import com.example.stndsbackend.common.SignUpResponse;
import com.example.stndsbackend.dto.LoginDTO;
import com.example.stndsbackend.dto.RegisterDTO;
import com.example.stndsbackend.service.authService.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private AuthService authService;


    @PostMapping("/SignUp")
    public ResponseEntity<SignUpResponse> signup(@RequestBody @Valid RegisterDTO registerDTO) {
        SignUpResponse signUpResponse = authService.signup(registerDTO);
        return ResponseEntity.ok(signUpResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = authService.login(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    }



