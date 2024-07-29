package com.example.stndsbackend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private Long id;
    @NotEmpty(message = "Firstname must not be empty")
    @Size(min = 2, max = 20)
    private String firstName;
    @NotEmpty(message = "Lastname must not be empty")
    @Size(min = 2, max = 20)
    private String lastName;
    @NotEmpty(message = "Lastname must not be empty")
    @Size(min = 6, max = 20)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty(message = "Confirm Password must not be empty")
    private String confirmPassword;
    private Integer age;
    @NotEmpty(message = "Gender must not be empty")
    private String gender;
    @Email
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Please enter a valid email!")
    private String email;
    @NotEmpty(message = "Location must not be empty")
    private String location;

}
