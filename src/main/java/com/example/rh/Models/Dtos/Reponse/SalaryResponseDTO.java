package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryResponseDTO {

    private Integer id;

    private LocalDate remunerationDate;

    private Double montant;

    private Double tempsTravail;

    private PersonnelResponseDTO employeeCin;
}
