package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate missingdate;

    private LocalDate Returndate;

    private Integer missingduration;

    private String missingmotif;

    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel personnel;

}
