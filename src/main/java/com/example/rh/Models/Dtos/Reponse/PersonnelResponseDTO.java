package com.example.rh.Models.Dtos.Reponse;

import java.time.LocalDate;
import java.util.List;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelResponseDTO extends UserResponseDTO {
    private String cin;

    private LocalDate dateOfBirth;
    private String hrAdministratorId;
    private List<AbsenceResponseDTO> absenceIds;
    private List<CongeResponseDTO> congeIds;
    private List<ContractResponseDTO> contractIds;
    private List<SalaryResponseDTO> salaryIds;
    private List<AdvantageResponseDTO> advantageIds;

}
