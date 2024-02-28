package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Conge;
import com.example.rh.Models.Entities.Personnel;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CongeRequestDTO {
    @NotNull
    private LocalDate startdate;

    @NotNull
    private LocalDate enddate;

    @NotNull
    private String  personnelCin;
    public Conge toModel(){
        Personnel personnel1= Personnel.builder().cin(personnelCin).build();
        return Conge.
                builder()
                .personnel(personnel1)
                .enddate(enddate)
                .startdate(startdate)
                .build();
    }
}
