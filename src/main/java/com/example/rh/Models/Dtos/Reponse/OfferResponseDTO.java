package com.example.rh.Models.Dtos.Reponse;
import com.example.rh.Models.Entities.Application;
import com.example.rh.Models.Entities.CandidacyStatistics;
import com.example.rh.Models.Entities.HrAdministrator;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponseDTO {
    private String title;

    private String description;

    private String city;

    private Double salary;

    private String image;

    private LocalDate dateCreation;

    private  String Profile;

    private HrAdministrationResponseDTO hradministrato;

    private List<CandidacyStatisticsResponseDTO> candidacyStatisticsList;

    private List<ApplicationResponseDTO> applicationList;
}
