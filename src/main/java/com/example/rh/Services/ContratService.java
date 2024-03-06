package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.ContractResponseDTO;
import com.example.rh.Models.Dtos.Request.ContractRequestDTO;
import com.example.rh.Models.Entities.Contract;

import java.util.List;

public interface ContratService extends Service<Contract,Long, ContractRequestDTO, ContractResponseDTO> {
    List<ContractResponseDTO> getContractByStartContract(String startContrat);
    List<ContractResponseDTO> getContratByEndContract(String endDate);
    List<ContractResponseDTO> getContratByPersonnel(String cin);
    List<ContractResponseDTO> getContratByContractType ( String contractType);
    ContractResponseDTO updateContractType ( String cin, String contractType);
}
