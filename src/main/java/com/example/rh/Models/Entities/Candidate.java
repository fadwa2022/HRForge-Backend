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
public class Candidate {
    @Id
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    @Lob
    private byte[] cvCandidat;

}
