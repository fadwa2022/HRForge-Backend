package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CongeResponseDTO {
    private Long id;
    private LocalDate startdate;
    private LocalDate enddate;
    private PersonnelResponseDTO personnelCin;
}
