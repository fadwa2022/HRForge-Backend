package com.example.rh.Services.Impl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.Company;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Role;
import com.example.rh.Models.Mappers.PersonnelMapper;
import com.example.rh.Repository.CompanyRepository;
import com.example.rh.Repository.HrAdministratorRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.PersonnelService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    private final PersonnelRepository personnelRepository;
    private final PersonnelMapper personnelMapper;
    private final HrAdministratorRepository hrAdministratorRepository;
    private final CompanyRepository companyRepository;


    @Autowired
    public PersonnelServiceImpl( CompanyRepository companyRepository,HrAdministratorRepository hrAdministratorRepository,PersonnelRepository personnelRepository,
                                 PersonnelMapper personnelMapper) {
        this.personnelMapper = personnelMapper;
        this.personnelRepository = personnelRepository;
        this.hrAdministratorRepository =hrAdministratorRepository;
        this.companyRepository = companyRepository;
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
        Optional<Personnel> existingPersonnelOptional = personnelRepository.findByEmail(request.getEmail());

        if (existingPersonnelOptional.isPresent()) {
            Personnel existingPersonnel = existingPersonnelOptional.get();
            if (existingPersonnel.isEnabled()) {
                throw new InternalServerErrorException("Email Already Taken");
            } else {
                request.setPassword(hashPassword("1234"));
                Personnel personnel= personnelMapper.reqToEntity(request);
                    personnelRepository.save(personnel);


                // todo: send email
                return personnelMapper.toRes(personnel);
            }
        } else {
            Personnel personnel = personnelRepository.save(personnelMapper.reqToEntity(request));
            return personnelMapper.toRes(personnel);
        }
    }

    @Override
    public PersonnelResponseDTO update(String cin, PersonnelRequestDTO request) {
        Optional<Personnel> personnelOptional = personnelRepository.findByCin(cin);
      Personnel personnelRequest= personnelMapper.reqToEntity(request);
        if (personnelOptional.isEmpty()) {
            throw new IllegalStateException("Personnel doesn't exist");
        }
        if (personnelRequest.getRole() == Role.CHRO){
            List<Company> company =  companyRepository.findAll();
            HrAdministrator hrAdministrator = new HrAdministrator(personnelRequest, company.get(0));
  hrAdministratorRepository.save(hrAdministrator);
        }

        Personnel updatedPersonel = personnelRepository.save(personnelRequest);

        if (personnelRequest.getEmail() ==null){
            updatedPersonel.setEmail(personnelOptional.get().getEmail());
        }
        if (personnelRequest.getPassword() ==null){
            updatedPersonel.setEmail(personnelOptional.get().getPassword());
        }
        return personnelMapper.toRes(updatedPersonel);

    }

    @Override
    public void deleteById(String cin) {
        personnelRepository.deleteById(cin);

    }

    @Override
    public PersonnelResponseDTO GetPersonnelByUserName(String username) {
        return personnelMapper.toRes(personnelRepository.findByUsername(username).get());
    }
    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
