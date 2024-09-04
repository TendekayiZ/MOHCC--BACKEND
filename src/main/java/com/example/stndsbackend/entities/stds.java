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
public class stds {
    @Id
    @Column(name = "Name")
    private String stdName;
    @Column(name = "Symptoms")
    public String symptoms;

}
