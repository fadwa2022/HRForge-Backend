package com.example.rh.Models.Dtos.Reponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HrAdministrationResponseDTO extends UserResponseDTO {

    private Long companyId;

    private Long generalAdministrationId;

    private List<OfferResponseDTO> offersRH;

    private List<PersonnelResponseDTO> personnelsRH;
}
