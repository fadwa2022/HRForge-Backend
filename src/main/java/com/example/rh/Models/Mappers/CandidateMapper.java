package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.CandidateResponseDTO;
import com.example.rh.Models.Dtos.Request.CandidateRequestDTO;
import com.example.rh.Models.Entities.Candidate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper implements IMapper<Candidate, CandidateRequestDTO, CandidateResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public CandidateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CandidateResponseDTO toRes(Candidate candidate) {
        return this.modelMapper
                .map(candidate,CandidateResponseDTO.class);
    }

    @Override
    public CandidateRequestDTO toReq(Candidate candidate) {
        return this.modelMapper
                .map(candidate,CandidateRequestDTO.class);
    }

    @Override
    public Candidate resToEntity(CandidateResponseDTO candidateResponseDTO) {
        return this.modelMapper
                .map(candidateResponseDTO,Candidate.class);
    }

    @Override
    public Candidate reqToEntity(CandidateRequestDTO candidateRequestDTO) {
        return this.modelMapper
                .map(candidateRequestDTO,Candidate.class);
    }
}
