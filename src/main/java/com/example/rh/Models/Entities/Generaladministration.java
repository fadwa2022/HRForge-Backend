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
public class Generaladministration {
    @Id
    private String cin;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "admin_id", cascade = CascadeType.ALL)
    private List<Hradministrato> hradministratoList;


}
