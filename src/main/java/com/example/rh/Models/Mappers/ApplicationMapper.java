package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Models.Entities.Application;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ApplicationMapper implements IMapper<Application, AdvantageRequestDTO, AdvantageResponseDTO> {
    private final ModelMapper modelMapper;

    @Autowired
    public ApplicationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AdvantageResponseDTO toRes(Application application) {
        return null;
    }

    @Override
    public AdvantageRequestDTO toReq(Application application) {
        return null;
    }

    @Override
    public Application resToEntity(AdvantageResponseDTO advantageResponseDTO) {
        return null;
    }

    @Override
    public Application reqToEntity(AdvantageRequestDTO advantageRequestDTO) {
        return null;
    }
}
