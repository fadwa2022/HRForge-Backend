package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Personnel extends User {
    @Id
    private String cin;

    private LocalDate dateofbirth;

    @ManyToOne
    @JoinColumn(name = "rhadministrato_id")
    private HrAdministrator hradministrator;

    @OneToMany(mappedBy = "personnel",
            cascade = CascadeType.ALL)
    private List<Absence> absenceList;

    @OneToMany(mappedBy = "personnel",
            cascade = CascadeType.ALL)
    private List<Conge> congeList;

    @OneToMany(mappedBy = "personnel",
            cascade = CascadeType.ALL)
    private List<Contract> contractList;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Salary> salaryList = new ArrayList<>();

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Advantage> advantageList = new ArrayList<>();




}
