package com.example.stndsbackend.controller;


import com.example.stndsbackend.common.dto.ChangePasswordDTO;
import com.example.stndsbackend.common.dto.LoginDTO;
import com.example.stndsbackend.common.dto.RegisterDTO;
import com.example.stndsbackend.common.response.LoginResponse;
import com.example.stndsbackend.common.response.ResponseData;
import com.example.stndsbackend.common.response.SignUpResponse;
import com.example.stndsbackend.service.authService.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/SignUp")
    public ResponseEntity<ResponseData<SignUpResponse>> signup(@RequestBody @Valid RegisterDTO registerDTO) {
        SignUpResponse signUpResponse = authService.signup(registerDTO);
        ResponseData<SignUpResponse> response = new ResponseData<SignUpResponse>().buildSuccessResponse("Signup successful", signUpResponse);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData<LoginResponse>> login(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = authService.login(loginDTO);
        ResponseData<LoginResponse> response = new ResponseData<LoginResponse>().buildSuccessResponse("Login successful", loginResponse);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change-password")
    public ResponseEntity<ResponseData<String>> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        boolean isChanged = authService.changePassword(changePasswordDTO);
        ResponseData<String> response = new ResponseData<String>();
        if (isChanged) {
            response.buildSuccessResponse("Password changed successfully!");
            return ResponseEntity.ok(response);
        } else {
            response.buildFailedResponse("Failed to change password: Invalid credentials or new password mismatch!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }



}