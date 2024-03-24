package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.suppl.AbsenceResponse;

import java.util.List;

public interface AbsenceService extends Service<Absence, Long, AbsenceRequestDTO, AbsenceResponseDTO>  {
     List<AbsenceResponseDTO> getAbsenceByPersonnel( String cin) ;
     List<AbsenceResponseDTO> getAbsenceByMissingDate(String missingDate);
     AbsenceResponse getAbsenceByPersonnelAndMissingDate(String cin, String missingDate);
      AbsenceResponseDTO updateAbsence(Long id, AbsenceRequestDTO request);
}
