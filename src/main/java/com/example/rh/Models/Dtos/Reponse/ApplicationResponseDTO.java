package com.example.rh.Models.Dtos.Reponse;

import com.example.rh.Models.Enum.EtatCandidature;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponseDTO {
    private Integer id;
    private CandidateResponseDTO candidate;
    private OfferResponseDTO offer;
    @Enumerated
    private EtatCandidature etatCandidature;
}
