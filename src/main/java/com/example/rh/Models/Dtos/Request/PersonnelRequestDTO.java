package com.example.rh.Models.Dtos.Request;

import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Entities.Personnel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelRequestDTO {
    @NotBlank(message = "Le prénom est obligatoire")
    private String first_name;

    @NotBlank(message = "Le nom de famille est obligatoire")
    private String last_name;

    @Email(message = "L'email doit être valide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    private String password;

    private String image;

    private String telephone;

    private String address;
    private String role;

    @NotBlank(message = "Le Cin est obligatoire")
    private String cin;

    @NotNull
    private LocalDate dateofbirth;



}
