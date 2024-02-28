package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String adress;

    private String image;

    private String numFiscal;

    @OneToMany(mappedBy = "company",
            cascade = CascadeType.ALL)
    private List<Generaladministration> generaladministrationslist;

    @OneToMany(mappedBy = "company",
            cascade = CascadeType.ALL)
    private  List<HrAdministrator> hradministratoList;
}
