package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate remunerationdate;

    private Double montant;

    private Double tempsTravail;

    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel employee;

}
