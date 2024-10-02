package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Student findByUsername(String username);

    Optional<Student> findByUsernameAndPassword(String username, String password);


}
