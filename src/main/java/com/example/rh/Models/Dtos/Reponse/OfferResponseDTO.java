package com.example.rh.Models.Dtos.Reponse;
import com.example.rh.Models.Entities.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponseDTO {
    private Integer id;
    private LocalDate dateCreation;
    private String description;
    private String profile;
    private Integer hrAdministratoId;
    private List<ApplicationResponseDTO> applicationList;
    //private List<> candidacyStatisticsList;
}
