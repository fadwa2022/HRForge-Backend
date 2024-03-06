package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Models.Entities.Advantage;

import java.util.List;

public interface AdvantageService extends Service<Advantage, Long, AdvantageRequestDTO, AdvantageResponseDTO>  {
    List<AdvantageResponseDTO> getAdvantageByRemunerationdate(String remunerationdate);
    List<AdvantageResponseDTO> getAdvantageByPersonnel (String cin);
    List<AdvantageResponseDTO> getAdvantageByPersonnelAndRemunerationDate ( String cin,
                                                                            String remunerationDate);
    }
