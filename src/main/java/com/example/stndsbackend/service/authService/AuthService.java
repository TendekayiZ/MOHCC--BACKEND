package com.example.stndsbackend.service.authService;

import com.example.stndsbackend.common.response.LoginResponse;
import com.example.stndsbackend.common.response.SignUpResponse;
import com.example.stndsbackend.common.dto.ChangePasswordDTO;
import com.example.stndsbackend.common.dto.LoginDTO;
import com.example.stndsbackend.common.dto.RegisterDTO;

public interface AuthService {
    SignUpResponse signup(RegisterDTO registerDTO);
    LoginResponse login(LoginDTO loginDTO);

    boolean changePassword(ChangePasswordDTO changePasswordDTO);


//    public interface UserService {
//        boolean changePassword(ChangePasswordDTO changePasswordDTO);
//    }

}
