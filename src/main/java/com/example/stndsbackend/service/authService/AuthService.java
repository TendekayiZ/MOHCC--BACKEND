package com.example.stndsbackend.service.authService;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;

import java.util.List;

public interface AuthService {
    RegisterRequest signup(RegisterRequest registerRequest);
    RegisterRequest getStudentById(Long studentsId) ;
    List<RegisterRequest> getAllStudents();
    RegisterRequest updateStudents(Long studentId, RegisterRequest updateStudent);
    void deleteStudents(Long studentId);
    LoginResponse login(LoginRequest loginRequest);
}
