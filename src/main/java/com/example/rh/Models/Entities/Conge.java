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
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startdate;

    private LocalDate enddate;

    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel personnel;
}
