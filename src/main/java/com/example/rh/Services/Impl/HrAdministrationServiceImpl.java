package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Mappers.HrAdministrationMapper;
import com.example.rh.Repository.HrAdministratorRepository;
import com.example.rh.Services.HrAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class HrAdministrationServiceImpl implements HrAdministratorService {

   private final HrAdministratorRepository hrAdministratorRepository;
   private final HrAdministrationMapper hrAdministrationMapper;
   private final EmailSender emailSender;


    @Autowired
    public HrAdministrationServiceImpl(EmailSender emailSender, HrAdministratorRepository hrAdministratorRepository,  HrAdministrationMapper hrAdministrationMapper) {
            this.hrAdministrationMapper = hrAdministrationMapper;
            this.hrAdministratorRepository =hrAdministratorRepository;
            this.emailSender=emailSender;
    }

    @Override
    public HrAdministrationResponseDTO getById(String cin) {
        Optional<HrAdministrator> hrAdministratorOptional = hrAdministratorRepository.findByCin(cin);
        return hrAdministratorOptional.map(hrAdministrationMapper::toRes).orElse(null);
    }

    @Override
    public Page<HrAdministrationResponseDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return hrAdministratorRepository.findAll(pageRequest).map(hrAdministrationMapper::toRes);
    }

    @Override
    public HrAdministrationResponseDTO create(HrAdministrationRequestDTO request) {
        if (!hrAdministratorRepository.existsByEmail(request.getEmail())) {
            throw new IllegalStateException("Email Already Taken");

        }
            HrAdministrator hrAdministrator = hrAdministrationMapper.reqToEntity(request);
        HrAdministrator savedAdministrator = hrAdministratorRepository.save(hrAdministrator);
        //todo : ajouter l envoi du mail
        return hrAdministrationMapper.toRes(savedAdministrator);
    }

    @Override
    public HrAdministrationResponseDTO update(String cin, HrAdministrationRequestDTO request) {
        Optional<HrAdministrator> hrAdministratorOptional = hrAdministratorRepository.findByCin(cin);

        if (hrAdministratorOptional.isEmpty()) {
            throw new IllegalStateException("Hr Administrator doesn't exist");
        }
   if (hrAdministratorOptional.get().getRole() != request.toModel().getRole()){

       String emailBody = "Good morning!\n" +
               "your cin : " + hrAdministratorOptional.get().getEmail()
               +
               "your new position administration is : " + hrAdministratorOptional.get().getRole();

       emailSender.sendMail(hrAdministratorOptional.get().getEmail(), new String[]{}, "Registration Successful", emailBody);
   }
        HrAdministrator hrAdministrator = hrAdministratorOptional.get();

        HrAdministrator updatedAdministrator = hrAdministratorRepository.save(hrAdministrator);
        return hrAdministrationMapper.toRes(updatedAdministrator);
    }

    @Override
    public void deleteById(String cin) {
        hrAdministratorRepository.deleteById(cin);

    }
}
