package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.*;
import com.example.rh.Models.Enum.TypeAvantage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvantageRequestDTO {
    @NotNull(message = "La date de rémunération est requise")
    private LocalDate remunerationdate;

    @NotNull(message = "Le montant est requis")
    @Positive(message = "Le montant doit être positif")
    private Double montant;

    @NotNull(message = "Le type d'avantage est requis")
    private TypeAvantage typeAvantage;

    @NotNull(message = "Le numéro CIN du personnel est requis")
    private String  personnelCin;
    public Advantage toModel(){
        Personnel personnel= Personnel.builder().cin(personnelCin).build();
        return Advantage.
                builder()
                .remunerationdate(remunerationdate)
                .montant(montant)
                .employee(personnel)
                .build();
    }
}
