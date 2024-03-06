package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceResponseDTO {
    private Long id;
    private LocalDate missingDate;
    private LocalDate returnDate;
    private Integer missingDuration;
    private String missingMotif;
    private PersonnelResponseDTO personnel;
}
