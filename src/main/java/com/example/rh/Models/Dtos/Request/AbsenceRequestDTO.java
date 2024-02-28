package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Personnel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestDTO {

    @NotNull(message = "Missing date is required")
    private LocalDate missingDate;

    @NotNull(message = "Return date is required")
    private LocalDate returnDate;

    @NotNull(message = "Missing duration is required")
    @Min(value = 1, message = "Missing duration must be greater than 0")
    private Integer missingDuration;

    @NotBlank(message = "Missing motif is required")
    private String missingMotif;

    @NotNull(message = "Personnel information is required")
    private String personnel;

    public Absence toModel(){
        Personnel personnel1= Personnel.builder().cin(personnel).build();
       return Absence.
                builder()
               .Returndate(returnDate)
               .missingdate(missingDate)
               .missingmotif(missingMotif)
               .missingduration(missingDuration)
               .personnel(personnel1)
                .build();
    }
}
