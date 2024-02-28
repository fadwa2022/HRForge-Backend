package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Entities.HrAdministrator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HrAdministrationMapper implements IMapper<HrAdministrator, HrAdministrationRequestDTO, HrAdministrationResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public HrAdministrationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HrAdministrationResponseDTO toRes(HrAdministrator hrAdministration) {
        return this.modelMapper
                .map(hrAdministration, HrAdministrationResponseDTO.class);
    }

    @Override
    public HrAdministrationRequestDTO toReq(HrAdministrator hrAdministration) {
        return this.modelMapper
                .map(hrAdministration, HrAdministrationRequestDTO.class);
    }

    @Override
    public HrAdministrator resToEntity(HrAdministrationResponseDTO hrAdministrationResponseDTO) {
        return this.modelMapper
                .map(hrAdministrationResponseDTO, HrAdministrator.class);
    }

    @Override
    public HrAdministrator reqToEntity(HrAdministrationRequestDTO hrAdministrationRequestDTO) {
        return this.modelMapper
                .map(hrAdministrationRequestDTO, HrAdministrator.class);
    }
}
