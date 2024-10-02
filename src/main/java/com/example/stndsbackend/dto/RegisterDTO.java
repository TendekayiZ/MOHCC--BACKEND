package com.example.stndsbackend.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private Long id;

    @NotEmpty(message = "username must not be empty")
    @Size(min = 4, max = 20)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty(message = "Confirm Password must not be empty")
    private String confirmPassword;

}
