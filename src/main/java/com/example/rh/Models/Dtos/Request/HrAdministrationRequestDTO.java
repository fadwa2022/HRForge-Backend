package com.example.rh.Models.Dtos.Request;
import com.example.rh.Models.Entities.*;
import com.example.rh.Models.Enum.Contracttype;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HrAdministrationRequestDTO extends UserRequestDTO {
    @NotNull(message = "Company ID is mandatory")
    private Long companyId;

    @NotNull(message = "General Administration ID is mandatory")
    private String generalAdministrationId;

    public HrAdministrator toModel(){
        Company company = Company.builder().id(companyId).build();
        Generaladministration generaladministration = Generaladministration.builder().cin(generalAdministrationId).build();
        return HrAdministrator.
                builder()
                .company(company)
                .generaladministration(generaladministration)
                .build();
    }

}
