package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.EtatCandidature;
import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offer offer;
    private EtatCandidature etatCandidature;
}
