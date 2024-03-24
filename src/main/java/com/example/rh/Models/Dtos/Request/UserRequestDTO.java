package com.example.rh.Models.Dtos.Request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class UserRequestDTO {
    @NotBlank(message = "Le prénom est obligatoire")
    private String first_name;

    @NotBlank(message = "Le nom de famille est obligatoire")
    private String last_name;

    @Email(message = "L'email doit être valide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;

    private String image;

    private String telephone;

    private String address;
    private String role;

}

