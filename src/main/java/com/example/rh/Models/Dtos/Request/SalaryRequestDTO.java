package com.example.rh.Models.Dtos.Request;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Entities.Salary;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequestDTO {

    @NotNull(message = "La date de rémunération est obligatoire")
    private LocalDate remunerationDate;

    @NotNull(message = "Le montant est obligatoire")
    private Double montant;

    @NotNull(message = "Le temps de travail est obligatoire")
    private Double tempsTravail;

    @NotNull(message = "Le CIN de l'employé est obligatoire")
    private String employeeCin;

    public Salary toModel(){
        Personnel personnel= Personnel.builder().cin(employeeCin).build();
        return Salary.
                builder()
                .montant(montant)
                .remunerationdate(remunerationDate)
                .employee(personnel)
                .tempsTravail(tempsTravail)
                .build();
    }
}
