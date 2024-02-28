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
public class HrAdministrator extends User{
    @Id
    private String cin;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Generaladministration generaladministration;

    @OneToMany(mappedBy = "hradministrator",
            cascade = CascadeType.ALL)
    private List<Offer> offerList;

    @OneToMany(mappedBy = "hradministrator",
            cascade = CascadeType.ALL)
    private List<Personnel> personnelList;
}
