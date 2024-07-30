package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctors,Long> {
}
