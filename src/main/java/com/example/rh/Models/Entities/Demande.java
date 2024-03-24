package com.example.rh.Models.Entities;

import com.example.rh.Models.Enum.MessageStatut;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String content;
    private MessageStatut statut;

    @ManyToOne
    @JoinColumn()
    private Personnel personnel;

}
