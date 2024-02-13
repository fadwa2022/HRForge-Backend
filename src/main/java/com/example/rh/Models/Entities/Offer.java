package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.hibernate.engine.internal.StatisticalLoggingSessionEventListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private LocalDate dateCreation;
    private  String discription;
    private  String Profile;
    @ManyToOne
    @JoinColumn(name = "rhadministrato_id")
    private Hradministrato hradministrato;
    @OneToMany(mappedBy = "offre_id", cascade = CascadeType.ALL)
    private List<CandidacyStatistics> candidacyStatisticsList;
    @OneToMany (mappedBy = "offre_id", cascade = CascadeType.ALL)
    private List<Application> applicationList;
}
