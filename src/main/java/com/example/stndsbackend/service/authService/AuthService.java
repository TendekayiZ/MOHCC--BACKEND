package com.example.stndsbackend.service.authService;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entities.Students;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    RegisterRequest signup(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);

}
