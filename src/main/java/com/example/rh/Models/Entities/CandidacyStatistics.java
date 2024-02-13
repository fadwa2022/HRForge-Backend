package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class CandidacyStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer NbreCandidatureParOffre;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private  Offer offer;

}
