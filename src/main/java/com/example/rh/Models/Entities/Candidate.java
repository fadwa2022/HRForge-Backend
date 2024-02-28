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
public class Candidate extends User  {

    @Id
    private String cin;

    private String cvCandidat;

    @OneToMany(mappedBy = "candidate",
            cascade = CascadeType.ALL)
    private  List<Application> applicationList;

}
