package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemandeResponse {
    private Long id;
    private String subject;
    private String content;
    private String statut;
    private PersonnelResponseDTO personnel;

}
