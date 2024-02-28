package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Entities.Personnel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelRequestDTO extends UserRequestDTO {

    @NotBlank(message = "Le Cin est obligatoire")
    private String cin;

    @NotNull
    private LocalDate dateofbirth;

    private String hradministrator;
    public Personnel toModel(){
        HrAdministrator hrAdministrator= HrAdministrator.builder().cin(hradministrator).build();
        return Personnel.
                builder()
                .hradministrator(hrAdministrator)
                .cin(cin)
                .build();
    }
}
