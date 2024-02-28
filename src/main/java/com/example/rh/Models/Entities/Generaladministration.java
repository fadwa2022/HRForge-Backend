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
public class Generaladministration extends User {
    @Id
    private String cin;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "generaladministration",
            cascade = CascadeType.ALL
    )
    private List<HrAdministrator> hradministratoList;


}
