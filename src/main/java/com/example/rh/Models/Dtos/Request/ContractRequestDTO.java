package com.example.rh.Models.Dtos.Request;
import com.example.rh.Models.Entities.Conge;
import com.example.rh.Models.Entities.Contract;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Contracttype;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ContractRequestDTO {
    private LocalDate startContract;

    @NotNull
    private LocalDate endContract;


    private Integer numero;

    @NotNull
    private Double remuneration;

    private String personnelCin;

    @NotNull
    private String contractType;

}
