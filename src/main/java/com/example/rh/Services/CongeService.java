package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.CongeResponseDTO;
import com.example.rh.Models.Dtos.Request.CongeRequestDTO;
import com.example.rh.Models.Entities.Conge;

import java.util.List;

public interface CongeService  extends Service<Conge, Long, CongeRequestDTO, CongeResponseDTO>{
    List<CongeResponseDTO> getCongeByStartDate(String startDate);
    List<CongeResponseDTO> getCongeByEndDate(String endDate);
    List<CongeResponseDTO> getCongeByPersonnel (String cin);
}
