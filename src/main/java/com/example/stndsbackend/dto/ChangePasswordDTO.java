package com.example.stndsbackend.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    // Getters and setters
    // ... (include getters and setters for all fields)
}

