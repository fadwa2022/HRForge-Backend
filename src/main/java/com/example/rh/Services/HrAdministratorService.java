package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Entities.HrAdministrator;

public interface HrAdministratorService extends Service<HrAdministrator, String, HrAdministrationRequestDTO, HrAdministrationResponseDTO> {
}
