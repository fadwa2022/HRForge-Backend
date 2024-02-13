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
public class CompanyResponseDTO {
    private Integer id;
    private String name;
    private String address;
    private String numFiscal;
    private List<GeneraladministrationResponseDTO> generaladministrationsList;
    private List<HradministrationResponseDTO> hradministrationsList;
}