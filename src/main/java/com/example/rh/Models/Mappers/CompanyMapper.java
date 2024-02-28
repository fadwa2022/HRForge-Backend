package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.CandidateResponseDTO;
import com.example.rh.Models.Dtos.Reponse.CompanyResponseDTO;
import com.example.rh.Models.Dtos.Request.CandidateRequestDTO;
import com.example.rh.Models.Dtos.Request.CompanyRequestDTO;
import com.example.rh.Models.Entities.Candidate;
import com.example.rh.Models.Entities.Company;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements IMapper<Company, CompanyRequestDTO, CompanyResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public CompanyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyResponseDTO toRes(Company company) {
        return this.modelMapper
                .map(company,CompanyResponseDTO.class);
    }

    @Override
    public CompanyRequestDTO toReq(Company company) {
        return this.modelMapper
                .map(company,CompanyRequestDTO.class);
    }

    @Override
    public Company resToEntity(CompanyResponseDTO companyResponseDTO) {
        return this.modelMapper
                .map(companyResponseDTO,Company.class);
    }

    @Override
    public Company reqToEntity(CompanyRequestDTO companyRequestDTO) {
        return this.modelMapper
                .map(companyRequestDTO,Company.class);
    }
}
