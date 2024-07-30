package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entity.Students;
import com.example.stndsbackend.exception.ResourceNotFoundException;
import com.example.stndsbackend.mapper.StudentMapper;
import com.example.stndsbackend.repository.StudentRepository;
import com.example.stndsbackend.service.authService.AuthService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private StudentRepository studentRepository;

    @Override
    public RegisterRequest signup(RegisterRequest registerRequest) {
        Students students = StudentMapper.mapToStudents(registerRequest);

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(students.getPassword());
        students.setPassword(encryptedPassword);

        String encryptedConfirmPassword = bcrypt.encode(students.getConfirmPassword());
        students.setConfirmPassword(encryptedConfirmPassword);

        Students savedStudents = studentRepository.save(students);
        return StudentMapper.mapToStudentDto(savedStudents);
    }

    @Override
    public RegisterRequest getStudentById(Long studentsId) {
        return null;
    }

    @Override
    public List<RegisterRequest> getAllStudents() {
        return null;
    }

    @Override
    public RegisterRequest updateStudents(Long studentId, RegisterRequest updateStudent) {
        return null;

    }


    @Override
    public void deleteStudents(Long studentId) {
        Students students = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException ("Student does not exist with given id" + studentId)
        );
        studentRepository.deleteById(studentId);

    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String msg = "";
        Students students = studentRepository.findByUsername(loginRequest.getUsername());
        if (students != null) {
            String password = loginRequest.getPassword();
           if (bcrypt.matches(loginRequest.getPassword(), students.getPassword())){
                Optional<Students> studentsOptional = studentRepository.findByUsernameAndPassword(
                        students.getUsername(), students.getPassword());
                if (studentsOptional.isPresent()) {
                    return new LoginResponse("Login Success",true);
                } else {
                    return new LoginResponse("Login Failed",true);
                }
            } else {
                return new LoginResponse("password incorrect", false);
            }
        }return new LoginResponse("username does not exist", false);


    }


    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "STD_table")
    public static class STDs {
        @Id
        @Column(name = "Name")
        private String stdName;
        @Column(name = "Nick_name")
        private String stdNickName;
        @Column(name = "Description")
        private String stiDescription;
        @Column(name = "Incubation_Period")
        private String incubationPeriod;
        @Column(name = "Danger")
        private String danger;

    }
}



