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
public class Hradministrato {
    @Id
    private String cin;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Generaladministration generaladministration;

    @OneToMany(mappedBy = "rhadministrato_id", cascade = CascadeType.ALL)
    private List<Offer> offerList;
    @OneToMany(mappedBy = "rhadministrato_id", cascade = CascadeType.ALL)
    private List<Personnel> personnelList;
}
