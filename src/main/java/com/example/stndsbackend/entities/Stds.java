package com.example.stndsbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Stds_table")
public class Stds {
    @Id
    @Column(name = "Name")
    private String name;
    @Column(name = "Symptoms")
    private String symptoms;


    public Stds(String stdName) {
    }
}
