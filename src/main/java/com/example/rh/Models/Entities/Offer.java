package com.example.rh.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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
    private Long id ;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)

    private String description;

    private String city;

    private Double salary;

    private String image;

    private LocalDate dateCreation;

    private  String Profile;

    @ManyToOne
    @JoinColumn(name = "rhadministrato_id")
    private HrAdministrator hradministrator;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<CandidacyStatistics> candidacyStatisticsList;

    @OneToMany (mappedBy = "offer", cascade = CascadeType.ALL)
    private List<Application> applicationList;
}
