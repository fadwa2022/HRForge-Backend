package com.example.rh.Models.Dtos.Request;

import jakarta.validation.Valid;
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
public class CompanyRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Fiscal number is mandatory")
    private String numFiscal;

}