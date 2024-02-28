package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Advantage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvantageMapper implements IMapper<Advantage, AdvantageRequestDTO, AdvantageResponseDTO>{

    private final ModelMapper modelMapper;

    @Autowired
    public AdvantageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public AdvantageResponseDTO toRes(Advantage advantage) {
        return this.modelMapper.map(advantage, AdvantageResponseDTO.class);
    }

    @Override
    public AdvantageRequestDTO toReq(Advantage advantage) {
        return this.modelMapper.map(advantage,AdvantageRequestDTO.class);
    }

    @Override
    public Advantage resToEntity(AdvantageResponseDTO advantageResponseDTO) {
        return this.modelMapper.map(advantageResponseDTO,Advantage.class );
    }

    @Override
    public Advantage reqToEntity(AdvantageRequestDTO advantageRequestDTO) {
        return this.modelMapper.map(advantageRequestDTO,Advantage.class);
    }
}
