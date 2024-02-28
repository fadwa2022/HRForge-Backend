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
    @NotNull
    private LocalDate startContract;

    @NotNull
    private LocalDate endContract;

    @NotNull
    private Integer numero;

    @NotNull
    private Double remuneration;

    @NotNull
    private String personnelCin;

    @NotNull
    private String contractType;
    public Contract toModel(){
        Personnel personnel1= Personnel.builder().cin(personnelCin).build();
       Contracttype contracttype = Contracttype.valueOf(contractType);
        return Contract.
                builder()
                .personnel(personnel1)
                .endcontract(endContract)
                .Remuneration(remuneration)
                .numero(numero)
                .startcontract(startContract)
                .contractType(contracttype)
                .build();
    }
}
