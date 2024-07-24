package com.example.stndsbackend.stds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stdRepository extends JpaRepository<stds, String> {
}
