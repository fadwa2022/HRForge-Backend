package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.Application;
import com.example.rh.Models.Entities.Candidate;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Enum.EtatCandidature;
import jakarta.validation.constraints.NotNull;

public class ApplicationRequestDTO {
    @NotNull(message = "Candidate is mandatory")
    private String candidateCin;

    @NotNull(message = "Offer is mandatory")
    private Long offerId;

    private String etatCandidature;
    public Application toModel() {
        Candidate candidate = Candidate.builder().cin(candidateCin).build();

        Offer offer = Offer.builder().id(offerId).build();

        EtatCandidature etatCandidatureEnum = EtatCandidature.valueOf(etatCandidature);

        Application application = Application.builder()
                .candidate(candidate)
                .offer(offer)
                .etatCandidature(etatCandidatureEnum)
                .build();

        return application;
    }
}
