package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.Personnel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonnelMapper implements IMapper<Personnel, PersonnelRequestDTO, PersonnelResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public PersonnelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonnelResponseDTO toRes(Personnel personnel) {
        return this.modelMapper.map(personnel, PersonnelResponseDTO.class);
    }

    @Override
    public PersonnelRequestDTO toReq(Personnel personnel) {
        return this.modelMapper.map(personnel, PersonnelRequestDTO.class);
    }

    @Override
    public Personnel resToEntity(PersonnelResponseDTO personnelResponseDTO) {
        return this.modelMapper.map(personnelResponseDTO, Personnel.class);
    }

    @Override
    public Personnel reqToEntity(PersonnelRequestDTO personnelRequestDTO) {
        return this.modelMapper.map(personnelRequestDTO, Personnel.class);
    }
}
