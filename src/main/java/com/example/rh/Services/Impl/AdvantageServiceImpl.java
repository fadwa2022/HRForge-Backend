package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Advantage;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Mappers.AbsenceMapper;
import com.example.rh.Models.Mappers.AdvantageMapper;
import com.example.rh.Repository.AbsenceRepository;
import com.example.rh.Repository.AdvantageRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.AdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvantageServiceImpl implements AdvantageService {
    private final AdvantageRepository advantageRepository;
    private final AdvantageMapper advantageMapper;
   private final PersonnelRepository personnelRepository;

    @Autowired
    public AdvantageServiceImpl( AdvantageRepository advantageRepository,  AdvantageMapper advantageMapper , PersonnelRepository personnelRepository) {
        this.advantageRepository = advantageRepository;
        this.advantageMapper = advantageMapper;
        this.personnelRepository = personnelRepository;
    }

    @Override
    public List<AdvantageResponseDTO> getAdvantageByRemunerationdate(String remunerationdate) {

        return advantageRepository.findByRemunerationdate(LocalDate.parse(remunerationdate))
                .stream()
                .map(advantageMapper::toRes)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvantageResponseDTO> getAdvantageByPersonnel(String cin) {
        Personnel personnel = personnelRepository.findByCin(cin).get();
        return advantageRepository.findByEmployee(personnel)
                .stream()
                .map(advantageMapper::toRes)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvantageResponseDTO> getAdvantageByPersonnelAndRemunerationDate(String cin, String remunerationDate) {
        Personnel personnel = personnelRepository.findByCin(cin).get();

        return advantageRepository.findByEmployeeAndRemunerationdate(personnel, LocalDate.parse(remunerationDate))
                .stream()
                .map(advantageMapper::toRes)
                .collect(Collectors.toList());
    }

    @Override
    public AdvantageResponseDTO getById(Long id) {
        Advantage advantage = advantageRepository.findById(id).orElse(null);

        return advantage != null ? advantageMapper.toRes(advantage) : null;
    }

    @Override
    public Page<AdvantageResponseDTO> getAll(int page, int size) {
        return null;
    }

    @Override
    public AdvantageResponseDTO create(AdvantageRequestDTO request) {
        Advantage advantage = advantageMapper.reqToEntity(request);

        advantage = advantageRepository.save(advantage);

        return advantageMapper.toRes(advantage);
    }

    @Override
    public AdvantageResponseDTO update(String id, AdvantageRequestDTO request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        advantageRepository.deleteById(id);

    }
}
