package com.example.stndsbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stds")
public class Std {
    @Id
    private String name;
    private String symptoms;


    public List<String> getSymptomsList() {
        return Arrays.asList(symptoms.split(","));
    }



}
