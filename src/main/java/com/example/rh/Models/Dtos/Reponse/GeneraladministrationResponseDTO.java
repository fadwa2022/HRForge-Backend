package com.example.rh.Models.Dtos.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneraladministrationResponseDTO {
    private String cin;
    private String lastName;
    private String firstName;
    private String email;
    private String company;
}
