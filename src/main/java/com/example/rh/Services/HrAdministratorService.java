package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.HrAdministrator;

public interface HrAdministratorService extends Service<HrAdministrator, Long, HrAdministrationRequestDTO, HrAdministrationResponseDTO> {
     HrAdministrationResponseDTO getByPersonnelCin(String cin);
     HrAdministrationResponseDTO getByPersonnelUserName(String username);

    void deleteByPersonnelCin(String cin);
    HrAdministrationResponseDTO UpdateHrPersonnel(String cin, PersonnelRequestDTO personnelRequestDTO);

}
