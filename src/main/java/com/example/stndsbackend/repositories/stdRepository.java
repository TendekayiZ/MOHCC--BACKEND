package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.stds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface stdRepository extends JpaRepository<stds, String>, JpaSpecificationExecutor<stds> {

}
