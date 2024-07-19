package com.example.stndsbackend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private Long id;
    @NotEmpty(message = "Firstname must not be empty")
    private String firstName;
    @NotEmpty(message = "Lastname must not be empty")
    private String lastName;
    @NotEmpty(message = "Lastname must not be empty")
    private String username;
    @NotEmpty(message = "Password must not be empty")
    private String password;
    @NotEmpty(message = "Confirm Password must not be empty")
    private String confirmPassword;
    private Integer age;
    @NotEmpty(message = "Gender must not be empty")
    private String gender;
    @Email
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @NotEmpty(message = "Location must not be empty")
    private String location;

}
