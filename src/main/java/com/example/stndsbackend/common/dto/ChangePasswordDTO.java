package com.example.stndsbackend.common.dto;

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

}

