package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.Application;
import com.example.rh.Models.Entities.CandidacyStatistics;
import com.example.rh.Models.Entities.Candidate;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Enum.EtatCandidature;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidacyStatisticsRequestDTO {
    @NotNull
    private Integer nbreCandidatureParOffre;

    @NotNull
    private Long offreId;
    public CandidacyStatistics toModel() {

        Offer offer = Offer.builder().id(offreId).build();


        CandidacyStatistics candidacyStatistics = CandidacyStatistics.builder()
                .offer(offer)
                .NbreCandidatureParOffre(nbreCandidatureParOffre)
                .build();

        return candidacyStatistics;
    }
}
