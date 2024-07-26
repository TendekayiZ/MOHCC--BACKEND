package com.example.stndsbackend.service;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.ForgotPasswordRequest;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entity.Students;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    RegisterRequest signup(RegisterRequest registerRequest);
    RegisterRequest getStudentById(Long studentsId) ;
    List<RegisterRequest> getAllStudents();
    RegisterRequest updateStudents(Long studentId, RegisterRequest updateStudent);
    void deleteStudents(Long studentId);
    LoginResponse login(LoginRequest loginRequest);

    void saveStudent(Students students);

    ForgotPasswordRequest forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

    void resetPassword(Students students, String newPassword);

    Optional<Students> findByEmail(String email);
}
