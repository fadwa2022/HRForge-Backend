package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.GeneraladministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.GeneralAdministrationRequestDTO;
import com.example.rh.Models.Entities.Generaladministration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralAdministrationMapper implements IMapper<Generaladministration, GeneralAdministrationRequestDTO, GeneraladministrationResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public GeneralAdministrationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GeneraladministrationResponseDTO toRes(Generaladministration generalAdministration) {
        return this.modelMapper
                .map(generalAdministration, GeneraladministrationResponseDTO.class);
    }

    @Override
    public GeneralAdministrationRequestDTO toReq(Generaladministration generalAdministration) {
        return this.modelMapper
                .map(generalAdministration, GeneralAdministrationRequestDTO.class);
    }

    @Override
    public Generaladministration resToEntity(GeneraladministrationResponseDTO generalAdministrationResponseDTO) {
        return this.modelMapper
                .map(generalAdministrationResponseDTO, Generaladministration.class);
    }

    @Override
    public Generaladministration reqToEntity(GeneralAdministrationRequestDTO generalAdministrationRequestDTO) {
        return this.modelMapper
                .map(generalAdministrationRequestDTO, Generaladministration.class);
    }
}
