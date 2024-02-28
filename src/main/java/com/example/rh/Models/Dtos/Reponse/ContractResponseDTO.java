package com.example.rh.Models.Dtos.Reponse;

import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Contracttype;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ContractResponseDTO {
    private Integer id;

    private LocalDate startcontract;

    private LocalDate endcontract;

    private Integer numero;

    private Double Remuneration;

    private Personnel personnel;

    private Contracttype contractType;
}
