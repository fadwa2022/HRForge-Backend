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
    private Integer id;
    private String name;
    private String adress;
    private String numFiscal;
    @OneToMany(mappedBy = "company_id", cascade = CascadeType.ALL)
    private List<Generaladministration> generaladministrationslist;
    @OneToMany(mappedBy = "company_id", cascade = CascadeType.ALL)
    private  List<Hradministrato> hradministratoList;
}
