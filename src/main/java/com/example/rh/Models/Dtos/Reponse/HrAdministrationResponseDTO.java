package com.example.rh.Models.Dtos.Reponse;
import com.example.rh.Models.Entities.Company;
import com.example.rh.Models.Entities.Generaladministration;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Entities.Personnel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HrAdministrationResponseDTO {

    private Long id;

    private PersonnelResponseDTO personnel;

    private CompanyResponseDTO companyId;

    private GeneraladministrationResponseDTO generalAdministrationId;


}
