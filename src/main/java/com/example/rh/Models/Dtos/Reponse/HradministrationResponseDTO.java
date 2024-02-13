package com.example.rh.Models.Dtos.Reponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HradministrationResponseDTO {

    private String cin;
    private String email;
    private String firstname;
    private String lastname;
    private Long companyId;
    private Long generalAdministrationId;
    private List<OfferResponseDTO> offersRH;
    private List<PersonnelResponseDTO> personnelsRH;
}
