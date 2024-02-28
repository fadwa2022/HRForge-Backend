package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CompanyResponseDTO {
    private Integer id;
    private String name;
    private String address;
    private String numFiscal;
    private List<GeneraladministrationResponseDTO> generaladministrationsList ;
    private List<HrAdministrationResponseDTO> hradministrationsList;
}