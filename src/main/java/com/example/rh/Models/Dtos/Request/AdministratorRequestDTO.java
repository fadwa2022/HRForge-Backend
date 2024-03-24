package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AdministratorRequestDTO {
    @NotBlank(message = "CIN is required")
    private String cin;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    @NotNull(message = "Admin ID is required")
    private String generaladministrationCin;
    public HrAdministrator toModel(){
        Company company= Company.builder().id(companyId).build();
        Personnel personnel = Personnel.builder().cin(cin).build();
        Personnel admin = Personnel.builder().cin(generaladministrationCin).build();

        Generaladministration generaladministration =Generaladministration.builder().personnel(admin).build();
        return HrAdministrator.
                builder()
                .generaladministration(generaladministration)
                .personnel(personnel)
                .company(company)
                .build();
    }
}
