package com.example.rh.Models.Dtos.Reponse;

import java.time.LocalDate;
import java.util.List;

import com.example.rh.Models.Entities.HrAdministrator;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelResponseDTO extends UserResponseDTO {
    private String cin;
    private String first_name;

    private String last_name;

    private String email;

    private String image;

    private String telephone;

    private String address;
    private String role;
    private LocalDate dateOfBirth;

}
