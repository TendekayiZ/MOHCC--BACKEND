package com.example.stndsbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "student")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "User_name")
    private String username;
    @Column(name = "password")
    private  String password;
    @Column(name = "confirm_password")
    private  String confirmPassword;
    @Column(name = ("age"))
    private Integer age;
    @Column(name = "Gender")
    private  String gender;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "location")
    private  String location;

    public Students(String email) {
    }
}
