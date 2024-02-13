package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;
    private LocalDate startdate;
    private LocalDate enddate;
    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel personnel;
}
