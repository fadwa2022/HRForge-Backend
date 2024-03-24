package com.example.rh.Models.Dtos.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneraladministrationResponseDTO {

    private  Long id ;
    private PersonnelResponseDTO personnel;

}
