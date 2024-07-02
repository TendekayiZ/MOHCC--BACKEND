package com.example.stndsbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsDto {
    private Long id;
    private  String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private String email;
}
