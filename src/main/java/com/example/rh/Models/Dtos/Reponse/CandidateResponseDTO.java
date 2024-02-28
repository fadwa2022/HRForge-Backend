package com.example.rh.Models.Dtos.Reponse;

import com.example.rh.Models.Entities.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponseDTO extends UserResponseDTO {

    private String cvCandidat;
    private List<ApplicationResponseDTO> applicationList;

}
