package com.example.rh.Models.Dtos.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequestDTO {
    private LocalDate dateCreation;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Profile is mandatory")
    private String profile;

    @NotNull(message = "HR Administrato ID is mandatory")
    private Integer hrAdministratoId;

}
