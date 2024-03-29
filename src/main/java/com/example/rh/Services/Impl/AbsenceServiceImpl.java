package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Mappers.AbsenceMapper;
import com.example.rh.Models.suppl.AbsenceResponse;
import com.example.rh.Repository.AbsenceRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;
    private final PersonnelRepository personnelRepository;


    @Autowired
    public AbsenceServiceImpl( AbsenceRepository absenceRepository, AbsenceMapper absenceMapper,PersonnelRepository personnelRepository) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
        this.personnelRepository = personnelRepository;
    }

    @Override
    public AbsenceResponseDTO getById(Long id) {
        Absence absence = absenceRepository.findById(id).orElse(null);
        return absenceMapper.toRes(absence);
    }

    @Override
    public Page<AbsenceResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return absenceRepository.findAll(pageRequest).map(absenceMapper::toRes);
    }

    @Override
    public AbsenceResponseDTO create(AbsenceRequestDTO request) {
        Absence absence = absenceMapper.reqToEntity(request);
        Absence savedAbsence = absenceRepository.save(absence);
        return absenceMapper.toRes(savedAbsence);
    }

    @Override
    public AbsenceResponseDTO update(String id, AbsenceRequestDTO request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public List<AbsenceResponseDTO> getAbsenceByPersonnel(String cin) {
        Personnel personnel = personnelRepository.findByCin(cin).get();
        List<Absence> absences = absenceRepository.findByPersonnel(personnel);
        List<AbsenceResponseDTO> responseDtos = new ArrayList<>();

        if (absences == null || absences.isEmpty()) {
            return Collections.emptyList();
        }
        for (Absence absence : absences) {
            responseDtos.add(absenceMapper.toRes(absence));
        }
        return responseDtos;
    }

    @Override
    public List<AbsenceResponseDTO> getAbsenceByMissingDate(String missingDate) {
        List<Absence> absences = absenceRepository.findByMissingdate(missingDate);
        List<AbsenceResponseDTO> responseDtos = new ArrayList<>();

        if (absences == null || absences.isEmpty()) {
            return Collections.emptyList();
        }
        for (Absence absence : absences) {
            responseDtos.add(absenceMapper.toRes(absence));
        }
        return responseDtos;
    }

    @Override
    public AbsenceResponse getAbsenceByPersonnelAndMissingDate(String cin, String missingDate) {
        List<Absence> absences = absenceRepository.findByMissingdate(missingDate);
        List<AbsenceResponseDTO> responseDtos = new ArrayList<>();

        int missingMonth = Integer.parseInt(missingDate.split("-")[1]);

        long daysBetween = 0;

        for (Absence absence : absences) {
            if (absence.getMissingdate().getMonthValue() == missingMonth) {
                LocalDate startDate = absence.getMissingdate();
                LocalDate endDate = absence.getReturndate();
                daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

                AbsenceResponseDTO responseDto = absenceMapper.toRes(absence);
                responseDtos.add(responseDto);
            }
        }

        return new AbsenceResponse(responseDtos,daysBetween);
    }
}
