package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidacyStatisticsResponseDTO {
    private Long id;
    private Integer nbreCandidatureParOffre;
    private Integer offreId;
}
