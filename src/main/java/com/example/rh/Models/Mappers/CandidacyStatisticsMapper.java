package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Reponse.CandidacyStatisticsResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.Dtos.Request.CandidacyStatisticsRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.CandidacyStatistics;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidacyStatisticsMapper implements IMapper<CandidacyStatistics, CandidacyStatisticsRequestDTO, CandidacyStatisticsResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public CandidacyStatisticsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CandidacyStatisticsResponseDTO toRes(CandidacyStatistics candidacyStatistics) {
        return this.modelMapper.map(candidacyStatistics,CandidacyStatisticsResponseDTO.class);
    }

    @Override
    public CandidacyStatisticsRequestDTO toReq(CandidacyStatistics candidacyStatistics) {
        return this.modelMapper
                .map(candidacyStatistics,CandidacyStatisticsRequestDTO.class);
    }

    @Override
    public CandidacyStatistics resToEntity(CandidacyStatisticsResponseDTO candidacyStatisticsResponseDTO) {
        return this.modelMapper
                .map(candidacyStatisticsResponseDTO,CandidacyStatistics.class);
    }

    @Override
    public CandidacyStatistics reqToEntity(CandidacyStatisticsRequestDTO candidacyStatisticsRequestDTO) {
        return this.modelMapper
                .map(candidacyStatisticsRequestDTO,CandidacyStatistics.class);    }
}
