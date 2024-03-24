package com.example.rh.Models.Dtos.Reponse;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CompanyResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String numFiscal;
}