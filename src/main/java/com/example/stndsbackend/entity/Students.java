package com.example.stndsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = ("age"))
    private Integer age;
    @Column(name = "password")
    private  String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
