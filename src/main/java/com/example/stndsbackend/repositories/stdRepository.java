package com.example.stndsbackend.repositories;

import com.example.stndsbackend.entities.Stds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface stdRepository extends JpaRepository<Stds, String> {

    @Query(value = "SELECT * FROM Stds s WHERE FIND_IN_SET(:symptom, s.Symptoms) > 0", nativeQuery = true)
    List<Stds> findBySymptom(@Param("symptom") String symptom);

}




