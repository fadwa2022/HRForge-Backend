package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper implements IMapper<Absence, AbsenceRequestDTO,AbsenceResponseDTO> {

    private final ModelMapper modelMapper;
    private final PersonnelRepository personnelRepository;

    @Autowired
    public AbsenceMapper(ModelMapper modelMapper, PersonnelRepository personnelRepository) {
        this.modelMapper = modelMapper;
        this.personnelRepository= personnelRepository;
    }

    @Override
    public AbsenceResponseDTO toRes(Absence absence) {

        return this.modelMapper
                .map(absence, AbsenceResponseDTO.class);
    }

    @Override
    public AbsenceRequestDTO toReq(Absence absence) {
        return this.modelMapper.map(absence, AbsenceRequestDTO.class);
    }

    @Override
    public Absence resToEntity(AbsenceResponseDTO absenceResponse) {
        return this.modelMapper.map(absenceResponse, Absence.class);
    }

    @Override
    public Absence reqToEntity(AbsenceRequestDTO absenceRequest) {
        return this.modelMapper.map(absenceRequest, Absence.class);
    }
}
