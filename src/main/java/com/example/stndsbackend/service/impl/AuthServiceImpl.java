package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.common.response.LoginResponse;
import com.example.stndsbackend.common.response.SignUpResponse;
import com.example.stndsbackend.common.dto.ChangePasswordDTO;
import com.example.stndsbackend.common.dto.LoginDTO;
import com.example.stndsbackend.common.dto.RegisterDTO;
import com.example.stndsbackend.entities.Student;
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
    public SignUpResponse signup(RegisterDTO registerDTO) {
        Student existingStudent = studentRepository.findByUsername(registerDTO.getUsername());
        if (existingStudent != null) {
            return new SignUpResponse("User already exists", false);
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return new SignUpResponse("Passwords do not match", false);
        }

        Student student = StudentMapper.mapToStudents(registerDTO);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(registerDTO.getPassword());
        student.setPassword(encryptedPassword);
        studentRepository.save(student);
        return new SignUpResponse("Registration successful", true);
    }







    @Override
    public LoginResponse login(LoginDTO loginDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String msg = "";
        Student student = studentRepository.findByUsername(loginDTO.getUsername());
        if (student != null) {
            String password = loginDTO.getPassword();
            if (bcrypt.matches(loginDTO.getPassword(), student.getPassword())) {
                Optional<Student> studentsOptional = studentRepository.findByUsernameAndPassword(
                        student.getUsername(), student.getPassword());
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
@Override
public boolean changePassword(ChangePasswordDTO changePasswordDTO) {
    Student student = studentRepository.findByUsername(changePasswordDTO.getUsername());
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    if (student == null) {
        return false;
    }
    if (!bcrypt.matches(changePasswordDTO.getOldPassword(), student.getPassword())) {
        return false;
    }
    if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmNewPassword())) {
        return false;
    }
    String encodedNewPassword = bcrypt.encode(changePasswordDTO.getNewPassword());
    student.setPassword(encodedNewPassword);
    studentRepository.save(student);
    System.out.println("Password changed for user: " + student.getUsername());
    return true;
}

//        @Override
//        public boolean changePassword(ChangePasswordDTO changePasswordDTO) {
//            return false;
//        }
    }









