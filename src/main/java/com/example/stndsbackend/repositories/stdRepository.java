package com.example.stndsbackend.repository;

import com.example.stndsbackend.entities.stds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stdRepository extends JpaRepository<stds, String> {
}
