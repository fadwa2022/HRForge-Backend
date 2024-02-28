package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.ContractResponseDTO;
import com.example.rh.Models.Dtos.Request.ContractRequestDTO;
import com.example.rh.Models.Entities.Contract;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper implements IMapper<Contract, ContractRequestDTO, ContractResponseDTO> {

private final ModelMapper modelMapper;

@Autowired
public ContractMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        }

    @Override
    public ContractResponseDTO toRes(Contract contract) {
        return this.modelMapper
                .map(contract,ContractResponseDTO.class);
    }

    @Override
    public ContractRequestDTO toReq(Contract contract) {
        return this.modelMapper
                .map(contract,ContractRequestDTO.class);
    }

    @Override
    public Contract resToEntity(ContractResponseDTO contractResponseDTO) {
        return this.modelMapper
                .map(contractResponseDTO,Contract.class);
    }

    @Override
    public Contract reqToEntity(ContractRequestDTO contractRequestDTO) {
        return this.modelMapper
                .map(contractRequestDTO,Contract.class);
    }
}
