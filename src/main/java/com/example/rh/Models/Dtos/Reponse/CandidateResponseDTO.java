package com.example.rh.Models.Dtos.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponseDTO {
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] cvCandidat;
}
