package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.Company;
import com.example.rh.Models.Entities.Generaladministration;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Role;
import com.example.rh.Models.Mappers.CompanyMapper;
import com.example.rh.Models.Mappers.CongeMapper;
import com.example.rh.Models.Mappers.HrAdministrationMapper;
import com.example.rh.Models.Mappers.PersonnelMapper;
import com.example.rh.Repository.CompanyRepository;
import com.example.rh.Repository.HrAdministratorRepository;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.HrAdministratorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class HrAdministrationServiceImpl implements HrAdministratorService {


    private final HrAdministratorRepository hrAdministratorRepository;
    private final PersonnelRepository personnelRepository;

    private final CompanyRepository companyRepository;

    private final HrAdministrationMapper hrAdministrationMapper;
    private final PersonnelMapper personnelMapper;
    private final CompanyMapper companyMapper;


    private final EmailSender emailSender;


    @Autowired
    public HrAdministrationServiceImpl(CompanyMapper companyMapper,PersonnelRepository personnelRepository,PersonnelMapper personnelMapper,CompanyRepository companyRepository,EmailSender emailSender, HrAdministratorRepository hrAdministratorRepository,  HrAdministrationMapper hrAdministrationMapper) {
            this.hrAdministrationMapper = hrAdministrationMapper;
            this.hrAdministratorRepository =hrAdministratorRepository;
            this.emailSender=emailSender;
        this.companyRepository  = companyRepository;
    this.personnelMapper = personnelMapper;
        this.personnelRepository =personnelRepository;
        this.companyMapper =companyMapper;
    }

    @Override
    public HrAdministrationResponseDTO getByPersonnelCin(String cin) {
        Optional<HrAdministrator> hrAdministratorOptional = hrAdministratorRepository.findByPersonnelCin(cin);
           Optional<HrAdministrationResponseDTO> hrAdministrator = hrAdministratorOptional.map(hrAdministrationMapper::toRes);

         //  Company newCompany = companyRepository.findById(hrAdministrator.get().getCompanyId().getId()).get();
           // hrAdministrator.get().setCompanyId(newCompany);

        return hrAdministrator.get();
    }

    @Override
    public HrAdministrationResponseDTO getByPersonnelUserName(String username) {
        return hrAdministrationMapper.toRes(hrAdministratorRepository.findByPersonnelUsername(username).get());
    }

    @Override
    public HrAdministrationResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public Page<HrAdministrationResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
       /* Page<HrAdministrationResponseDTO> hrAdministratorsPage = hrAdministratorRepository.findAll(pageRequest).map(hrAdministrationMapper::toRes);

        for (HrAdministrationResponseDTO hrAdministrator : hrAdministratorsPage.getContent()) {
            Personnel newPersonnel =personnelRepository.findByCin(hrAdministrator.getPersonnel().getCin()).get();
            hrAdministrator.setPersonnel(newPersonnel);

             }
        return hrAdministratorsPage;*/
        return  hrAdministratorRepository.findAll(pageRequest).map(hrAdministrationMapper::toRes);
    }

    @Override
    public HrAdministrationResponseDTO create(HrAdministrationRequestDTO request) {
        if (!hrAdministratorRepository.existsByPersonnelEmail(request.getHrAdministratorPersonnel().getEmail())) {
            throw new IllegalStateException("Email Already Taken");

        }
            HrAdministrator hrAdministrator = hrAdministrationMapper.reqToEntity(request);
        HrAdministrator savedAdministrator = hrAdministratorRepository.save(hrAdministrator);
        //todo : ajouter l envoi du mail
        return hrAdministrationMapper.toRes(savedAdministrator);
    }

    @Override
    public HrAdministrationResponseDTO update(String cin, HrAdministrationRequestDTO request) {
      return null;
    }

    @Override
    public void deleteById(Long id) {
        hrAdministratorRepository.deleteById(id);
    }

    @Override
    @Transactional

    public void deleteByPersonnelCin(String cin) {
        hrAdministratorRepository.deleteByPersonnelCin(cin);
    }

    @Override
    public HrAdministrationResponseDTO UpdateHrPersonnel(String cin, PersonnelRequestDTO personnelRequestDTO) {

        Optional<HrAdministrator> hrAdministratorOptional = hrAdministratorRepository.findByPersonnelCin(cin);
        if (hrAdministratorOptional.isEmpty()) {
            throw new IllegalStateException("Hr Administrator doesn't exist");
        }

        hrAdministratorOptional.get().setPersonnel(personnelMapper.reqToEntity(personnelRequestDTO));
        Personnel personnelupdate = personnelRepository.save(personnelMapper.reqToEntity(personnelRequestDTO));

        if (Role.CHRO != personnelMapper.reqToEntity(personnelRequestDTO).getRole() ){

            this.deleteById(hrAdministratorOptional.get().getId());

            this.SendEmail(personnelupdate);
        return null;


        }else {
            HrAdministrator updatedAdministrator = hrAdministratorRepository.findByPersonnelCin(personnelupdate.getCin()).get();
            return hrAdministrationMapper.toRes(updatedAdministrator);

        }

    }
    public void SendEmail (Personnel personnelupdate){
        String emailBody = "Your Post Is changed!\n" +
                " Mr/Mss: " + personnelupdate.getFirst_name()+" "+personnelupdate.getLast_name()
                +
                " The new position is: " + personnelupdate.getRole();


        emailSender.sendMail(personnelupdate.getEmail(), new String[]{}, "Post  changed", emailBody);

    }
}
