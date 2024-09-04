package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Students, Long> {
    Students findByUsername(String username);

    Optional<Students> findByUsernameAndPassword(String username, String password);

}
