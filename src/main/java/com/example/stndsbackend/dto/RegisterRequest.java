package com.example.stndsbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private  String password;
    private  String confirmPassword;
    private Integer age;
    private  String gender;
    private String email;
    private  String location;

}
