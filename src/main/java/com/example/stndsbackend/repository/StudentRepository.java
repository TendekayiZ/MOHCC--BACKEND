package com.example.stndsbackend.repository;

import com.example.stndsbackend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Students, Long>{
}
