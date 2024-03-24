package com.example.rh.Models.Dtos.Request;
import com.example.rh.Models.Entities.*;
import com.example.rh.Models.Enum.Contracttype;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HrAdministrationRequestDTO   {
    @NotNull(message = "Company ID is mandatory")
    private Long companyId;

    @NotNull(message = "General Administration ID is mandatory")
    private Long generalAdministrationId;

    private Personnel HrAdministratorPersonnel;

    public HrAdministrator toModel(){
        Company company = Company.builder().id(companyId).build();
        Generaladministration generaladministration1 = Generaladministration.builder().id(generalAdministrationId).build();

        return HrAdministrator.
                builder()
                .personnel(HrAdministratorPersonnel)
                .company(company)
                .generaladministration(generaladministration1)
                .build();
    }

}
