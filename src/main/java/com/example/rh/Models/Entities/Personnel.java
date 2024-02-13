package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Personnel {
    @Id
    private String cin;
    private String firstname;
    private String lastname;
    private String adresse;
    private LocalDate dateofbirth;
    private Integer telephone;
    private Double remuneration;
    @ManyToOne
    @JoinColumn(name = "rhadministrato_id")
    private Hradministrato hradministrato;
    @OneToMany(mappedBy = "personnel_cin", cascade = CascadeType.ALL)
    private List<Absence> absenceList;
    @OneToMany(mappedBy = "personnel_cin", cascade = CascadeType.ALL)
    private List<Conge> congeList;
    @OneToMany(mappedBy = "personnel_cin", cascade = CascadeType.ALL)
    private List<Contract> contractList;


}
