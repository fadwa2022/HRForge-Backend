package com.example.rh.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class HrAdministrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonManagedReference

    private Personnel personnel;

    @ManyToOne
    @JsonBackReference

    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne

    @JoinColumn(name = "admin_id")
    private Generaladministration generaladministration;

    @OneToMany(mappedBy = "hradministrator",
            cascade = CascadeType.ALL)
    private List<Offer> offerList;



    public HrAdministrator(Personnel personnel, Company company) {
        this.personnel = personnel;
        this.company = company;
    }
}
