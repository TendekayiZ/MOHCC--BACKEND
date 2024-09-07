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
@Table(name = "Stds")
public class Stds {
    @Id
    @Column(name = "Name")
    private String name;
    @Column(name = "Symptoms")
    private String symptoms;


    public List<String> getSymptomsList() {
        return Arrays.asList(symptoms.split(","));
    }


    public Stds(String stdName) {
    }
}
