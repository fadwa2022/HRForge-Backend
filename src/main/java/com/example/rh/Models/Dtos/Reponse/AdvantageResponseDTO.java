package com.example.rh.Models.Dtos.Reponse;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.TypeAvantage;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvantageResponseDTO {
    private LocalDate remunerationdate;
    private Double montant;
    private TypeAvantage typeAvantage;
    private Personnel personnel;
}
