package com.example.stndsbackend.service.authService;

import com.example.stndsbackend.common.LoginResponse;
import com.example.stndsbackend.common.SignUpResponse;
import com.example.stndsbackend.dto.LoginDTO;
import com.example.stndsbackend.dto.RegisterDTO;

public interface AuthService {
    SignUpResponse signup(RegisterDTO registerDTO);
    LoginResponse login(LoginDTO loginDTO);

}
