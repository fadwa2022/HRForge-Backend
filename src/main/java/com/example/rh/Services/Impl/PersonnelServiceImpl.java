package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Mappers.PersonnelMapper;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.PersonnelService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    private final PersonnelRepository personnelRepository;
    private final PersonnelMapper personnelMapper;

    @Autowired
    public PersonnelServiceImpl( PersonnelRepository personnelRepository,
                                 PersonnelMapper personnelMapper) {
        this.personnelMapper = personnelMapper;
        this.personnelRepository = personnelRepository;
    }
    @Override
    public PersonnelResponseDTO getById(String cin) {
        Optional<Personnel> personnelOptional = personnelRepository.findByCin(cin);
        return personnelOptional.map(personnelMapper::toRes).orElseThrow(() -> new EntityNotFoundException("Personnel Not Exist with the given Cin : " + cin));
    }

    @Override
    public Page<PersonnelResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return personnelRepository.findAll(pageRequest).map(personnelMapper::toRes);
    }

    @Override
    public PersonnelResponseDTO create(PersonnelRequestDTO request) {

        if (!personnelRepository.existsById(request.getCin())) {
            Personnel personnel = personnelRepository.save(personnelMapper.reqToEntity(request));
            return personnelMapper.toRes(personnel);
        }

        Personnel personnel = personnelRepository.findByEmail(request.getEmail()).get();
        if (!personnel.isEnabled()) {
           Personnel personnelRequest =personnelMapper.reqToEntity(request);
            personnel.setCin(personnelRequest.getCin());
            personnel.setDateofbirth(personnelRequest.getDateofbirth());
            personnel.setHradministrator(personnelRequest.getHradministrator());
            personnel.setAddress(personnelRequest.getAddress());
            personnel.setEmail(personnelRequest.getEmail());
            personnel.setFirst_name(personnelRequest.getFirst_name());
            personnel.setLast_name(personnelRequest.getLast_name());
            personnel.setTelephone(personnelRequest.getTelephone());
            personnel.setPassword("0000");
            personnel.setRole(personnelRequest.getRole());
            personnelRepository.save(personnel);
            //todo:send email

            return personnelMapper.toRes(personnel);
        } else {
            throw new InternalServerErrorException("Email Already Taken");
        }    }

    @Override
    public PersonnelResponseDTO update(String cin, PersonnelRequestDTO request) {
        Optional<Personnel> personnelOptional = personnelRepository.findByCin(cin);

        if (personnelOptional.isEmpty()) {
            throw new IllegalStateException("Personnel doesn't exist");
        }

        Personnel personnel = personnelOptional.get();

        Personnel updatedPersonel = personnelRepository.save(personnel);
        return personnelMapper.toRes(updatedPersonel);

    }

    @Override
    public void deleteById(String cin) {
        personnelRepository.deleteById(cin);

    }
}
