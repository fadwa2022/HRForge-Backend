package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.TypeAvantage;
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
public class Advantage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate remunerationdate;

    private Double montant;

    @Enumerated(EnumType.STRING)
    private TypeAvantage typeAvantage;

    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel employee;
}
