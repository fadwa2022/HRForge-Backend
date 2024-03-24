package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.Role;
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


    @OneToMany(mappedBy = "personnel")
    private List<Absence> absenceList;

    @OneToMany(mappedBy = "personnel")
    private List<Conge> congeList;

    @OneToMany(mappedBy = "personnel")
    private List<Contract> contractList;

    @OneToMany(mappedBy = "employee")
    private List<Salary> salaryList = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Advantage> advantageList = new ArrayList<>();




}
