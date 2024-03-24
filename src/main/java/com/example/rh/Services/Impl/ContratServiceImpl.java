package com.example.rh.Services.Impl;

import com.example.rh.Exceptions.PersonnelNotFoundException;
import com.example.rh.Models.Dtos.Reponse.ContractResponseDTO;
import com.example.rh.Models.Dtos.Request.ContractRequestDTO;
import com.example.rh.Models.Entities.Contract;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Contracttype;
import com.example.rh.Models.Mappers.ContractMapper;
import com.example.rh.Repository.ContractRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratServiceImpl implements ContratService {
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    private final PersonnelRepository personnelRepository;

    @Autowired
    public ContratServiceImpl(ContractRepository contractRepository,ContractMapper contractMapper, PersonnelRepository personnelRepository) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
        this.personnelRepository = personnelRepository;
    }

    @Override
    public ContractResponseDTO getById(Long id) {
        Contract contract = contractRepository.findById(id).orElse(null);

        if (contract == null) {
            return null;
        }
        return contractMapper.toRes(contract);

    }

    @Override
    public Page<ContractResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return contractRepository.findAll(pageRequest).map(contractMapper::toRes);

    }

    @Override
    public ContractResponseDTO create(ContractRequestDTO request) {
        Contract contract = contractMapper.reqToEntity(request);
        LocalDate localDate = LocalDate.now();
        contract.setStartcontract(localDate);

        Optional<Personnel> personnelOptional = personnelRepository.findByCin(request.getPersonnelCin());
        if (personnelOptional.isPresent()) {
            contract.setPersonnel(personnelOptional.get());
            Contract savedContract = contractRepository.save(contract);
            return contractMapper.toRes(savedContract);
        } else {
            throw new PersonnelNotFoundException("Personnel not found for Cin: " + request.getPersonnelCin());
        }
    }


    @Override
    public ContractResponseDTO update(String id, ContractRequestDTO request) {
        Long longId;
        try {
            longId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }

        Contract existingContract = contractRepository.findById(longId).orElse(null);

        if (existingContract == null) {
            return null;
        }

        existingContract.setContractType(contractMapper.reqToEntity(request).getContractType());
        existingContract.setEndcontract(request.getEndContract());
        contractRepository.save(existingContract);

        return contractMapper.toRes(existingContract);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);

    }
    @Override
    public List<ContractResponseDTO> getContractByStartContract(String startContrat) {
        return contractRepository.findByStartcontract(LocalDate.parse(startContrat))
                .stream()
                .map(contractMapper::toRes)
                .collect(Collectors.toList());
    }
    @Override
    public List<ContractResponseDTO> getContratByEndContract(String endDate) {
        return contractRepository.findByEndcontract(LocalDate.parse(endDate))
                .stream()
                .map(contractMapper::toRes)
                .collect(Collectors.toList());
    }
    @Override
    public List<ContractResponseDTO> getContratByPersonnel(String cin) {
        Personnel personnel = personnelRepository.findByCin(cin).get();
        return contractRepository.findByPersonnel(personnel)
                .stream()
                .map(contractMapper::toRes)
                .collect(Collectors.toList());
    }
    @Override
    public  List<ContractResponseDTO> getContratByContractType ( String contractType) {
        return contractRepository.findByContractType(Contracttype.valueOf(contractType))
                .stream()
                .map(contractMapper::toRes)
                .collect(Collectors.toList());    }
    @Override
    public ContractResponseDTO updateContractType ( String cin, String contractType) {
        List<Contract> contracts= getContratByPersonnel(cin)
                .stream()
                .map(contractMapper::resToEntity)
                .toList();


        if (contracts.isEmpty()) {
            return null;
        }

        Contract latestContract = contracts.stream()
                .max(Comparator.comparing(Contract::getEndcontract))
                .orElse(null);

        if (latestContract == null) {
            return null;
        }

        latestContract.setContractType(Contracttype.valueOf(contractType));
        contractRepository.save(latestContract);

        return contractMapper.toRes(latestContract);
    }
}

