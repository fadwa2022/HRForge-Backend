package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.SalaryResponseDTO;
import com.example.rh.Models.Dtos.Request.SalaryRequestDTO;
import com.example.rh.Models.Entities.Salary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapper implements IMapper<Salary, SalaryRequestDTO, SalaryResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public SalaryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SalaryResponseDTO toRes(Salary salary) {
        return this.modelMapper
                .map(salary, SalaryResponseDTO.class);
    }

    @Override
    public SalaryRequestDTO toReq(Salary salary) {
        return this.modelMapper
                .map(salary, SalaryRequestDTO.class);
    }

    @Override
    public Salary resToEntity(SalaryResponseDTO salaryResponseDTO) {
        return this.modelMapper
                .map(salaryResponseDTO, Salary.class);
    }

    @Override
    public Salary reqToEntity(SalaryRequestDTO salaryRequestDTO) {
        return this.modelMapper
                .map(salaryRequestDTO, Salary.class);
    }
}
