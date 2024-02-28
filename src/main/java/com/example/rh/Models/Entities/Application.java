package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.EtatCandidature;
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
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offer offer;

    @Enumerated(EnumType.STRING)
    private EtatCandidature etatCandidature;

    private LocalDate dateCandidature;
}
