package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.Personnel;

public interface PersonnelService  extends Service<Personnel, String, PersonnelRequestDTO, PersonnelResponseDTO> {
}
