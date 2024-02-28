package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.CongeResponseDTO;
import com.example.rh.Models.Dtos.Request.CongeRequestDTO;
import com.example.rh.Models.Entities.Conge;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CongeMapper implements IMapper<Conge, CongeRequestDTO, CongeResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public CongeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CongeResponseDTO toRes(Conge conge) {
        return this.modelMapper
                .map(conge,CongeResponseDTO.class);
    }

    @Override
    public CongeRequestDTO toReq(Conge conge) {
        return this.modelMapper
                .map(conge,CongeRequestDTO.class);
    }

    @Override
    public Conge resToEntity(CongeResponseDTO congeResponseDTO) {
        return this.modelMapper
                .map(congeResponseDTO,Conge.class);
    }

    @Override
    public Conge reqToEntity(CongeRequestDTO congeRequestDTO) {
        return this.modelMapper
                .map(congeRequestDTO,Conge.class);
    }
}
