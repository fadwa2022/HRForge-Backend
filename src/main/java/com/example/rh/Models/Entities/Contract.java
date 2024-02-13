package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.Contracttype;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Contract {
    @Id
    private Integer id;
    private LocalDate startcontract;
    private LocalDate endcontract;
    private Integer numero;
    private Double Remuneration;
    @ManyToOne
    @JoinColumn(name = "personnel_cin")
    private Personnel personnel;

    private Contracttype contractType;


}
