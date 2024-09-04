package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entities.Students;
import com.example.stndsbackend.mapper.StudentMapper;
import com.example.stndsbackend.repositories.StudentRepository;
import com.example.stndsbackend.service.authService.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private StudentRepository studentRepository;

    @Override
    public RegisterRequest signup(RegisterRequest registerRequest) {

        Students students = StudentMapper.mapToStudents(registerRequest);

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(registerRequest.getPassword());
        students.setPassword(encryptedPassword);

        String encryptedConfirmPassword = bcrypt.encode(registerRequest.getConfirmPassword());
        students.setConfirmPassword(encryptedConfirmPassword);

        Students savedStudents = studentRepository.save(students);
        return StudentMapper.mapToStudentDto(savedStudents);
    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String msg = "";
        Students students = studentRepository.findByUsername(loginRequest.getUsername());
        if (students != null) {
            String password = loginRequest.getPassword();
            if (bcrypt.matches(loginRequest.getPassword(), students.getPassword())) {
                Optional<Students> studentsOptional = studentRepository.findByUsernameAndPassword(
                        students.getUsername(), students.getPassword());
                if (studentsOptional.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", true);
                }
            } else {
                return new LoginResponse("password incorrect", false);
            }
        }
        return new LoginResponse("username does not exist", false);


    }



}





