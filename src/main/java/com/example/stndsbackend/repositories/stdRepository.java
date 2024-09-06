package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.Stds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface stdRepository extends JpaRepository<Stds, String>, JpaSpecificationExecutor<Stds> {

    Optional<Stds> findBySymptoms(String symptoms);
}