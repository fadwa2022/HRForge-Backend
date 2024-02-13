package com.example.rh.Models.Dtos.Reponse;

import com.example.rh.Models.Enum.EtatCandidature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponseDTO {
    private Integer id;
    private CandidateResponseDTO candidate;
    private OfferResponseDTO offer;
    private EtatCandidature etatCandidature;
}
