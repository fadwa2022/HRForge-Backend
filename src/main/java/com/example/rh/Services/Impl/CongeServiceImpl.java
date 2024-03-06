package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.CongeResponseDTO;
import com.example.rh.Models.Dtos.Request.CongeRequestDTO;
import com.example.rh.Models.Entities.Conge;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Mappers.CongeMapper;
import com.example.rh.Repository.CongeRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CongeServiceImpl implements CongeService {
    private final CongeRepository congeRepository;
    private final CongeMapper congeMapper;

    private final PersonnelRepository personnelRepository;

    @Autowired
    public CongeServiceImpl(CongeRepository congeRepository,CongeMapper congeMapper ,PersonnelRepository personnelRepository) {
        this.congeRepository = congeRepository;
        this.congeMapper = congeMapper;
        this.personnelRepository=personnelRepository;
    }

    @Override
    public List<CongeResponseDTO> getCongeByStartDate(String startDate) {
        return congeRepository.findByStartDate(LocalDate.parse(startDate))
                .stream()
                .map(congeMapper::toRes)
                .collect(Collectors.toList());
    }

    @Override
    public List<CongeResponseDTO> getCongeByEndDate(String endDate) {

        return congeRepository.findByEndDate(LocalDate.parse(endDate))
                .stream()
                .map(congeMapper::toRes)
                .collect(Collectors.toList());

    }

    @Override
    public List<CongeResponseDTO> getCongeByPersonnel(String cin) {
        Personnel personnel = personnelRepository.findByCin(cin).get();

        return congeRepository.findByPersonnel(personnel)
                .stream()
                .map(congeMapper::toRes)
                .collect(Collectors.toList());   }

    @Override
    public CongeResponseDTO getById(Long id) {
        Optional<Conge> conge = congeRepository.findById(id);
        return conge.map(congeMapper::toRes).orElse(null);
    }

    @Override
    public Page<CongeResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return congeRepository.findAll(pageRequest).map(congeMapper::toRes);
    }

    @Override
    public CongeResponseDTO create(CongeRequestDTO request) {
        Conge conge = congeMapper.reqToEntity(request);
        Conge savedConge = congeRepository.save(conge);
        return congeMapper.toRes(savedConge);
    }

    @Override
    public CongeResponseDTO update(String id, CongeRequestDTO request) {
        Long congeId = Long.parseLong(id);
        Optional<Conge> conge = congeRepository.findById(congeId);
        if (conge.isPresent()) {
            Conge updatedConge = congeMapper.reqToEntity(request);
            Conge savedConge = congeRepository.save(updatedConge);
            return congeMapper.toRes(savedConge);
        } else {
            return null;
        }    }

    @Override
    public void deleteById(Long id) {
        congeRepository.deleteById(id);

    }
}
