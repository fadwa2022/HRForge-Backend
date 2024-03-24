package com.example.rh.Models.Dtos.Request;
import com.example.rh.Models.Entities.Contract;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Offer;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Contracttype;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
    @NotBlank
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private String city;

    @PositiveOrZero
    private Double salary;

    private String image;

    private LocalDate dateCreation;

    @NotBlank(message = "Profile is mandatory")
    private String profile;

    @NotNull(message = "HR Administrato ID is mandatory")
    private String  hrAdministratoId;

    public Offer toModel(){
        Personnel personnel = Personnel.builder().cin(hrAdministratoId).build();

        HrAdministrator hrAdministrator= HrAdministrator.builder().personnel(personnel).build();
        return Offer.
                builder()
                .city(city)
                .Profile(profile)
                .hradministrator(hrAdministrator)
                .image(image)
                .salary(salary)
                .title(title)
                .description(description)
                .dateCreation(dateCreation)
                .build();
    }
}
