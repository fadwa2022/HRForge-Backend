package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Entities.Company;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Repository.CompanyRepository;
import com.example.rh.Repository.CongeRepository;
import com.example.rh.Repository.PersonnelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class HrAdministrationMapper implements IMapper<HrAdministrator, HrAdministrationRequestDTO, HrAdministrationResponseDTO> {

    private final ModelMapper modelMapper;
    private  final PersonnelMapper personnelMapper;
    private final PersonnelRepository personnelRepository;
    private final CompanyRepository companyRepository;
    private final  CompanyMapper companyMapper;

    @Autowired
    public HrAdministrationMapper(CompanyMapper companyMapper,PersonnelMapper personnelMapper,CompanyRepository companyRepository,ModelMapper modelMapper,PersonnelRepository personnelRepository) {
        this.modelMapper = modelMapper;
        this.personnelRepository = personnelRepository;
        this.companyRepository = companyRepository;
        this.personnelMapper =personnelMapper;
        this.companyMapper =companyMapper;
    }

    @Override
    public HrAdministrationResponseDTO toRes(HrAdministrator hrAdministration) {

        HrAdministrationResponseDTO hrAdministrators = this.modelMapper
               .map(hrAdministration, HrAdministrationResponseDTO.class);


         hrAdministrators.setPersonnel(personnelMapper.toRes(personnelRepository.findByCin(hrAdministrators.getPersonnel().getCin()).get()));
         hrAdministrators.setCompanyId(companyMapper.toRes(companyRepository.findById(hrAdministrators.getCompanyId().getId()).get()));


     return hrAdministrators;
   }

    @Override
    public HrAdministrationRequestDTO toReq(HrAdministrator hrAdministration) {
        return this.modelMapper
                .map(hrAdministration, HrAdministrationRequestDTO.class);
    }

    @Override
    public HrAdministrator resToEntity(HrAdministrationResponseDTO hrAdministrationResponseDTO) {
        return this.modelMapper
                .map(hrAdministrationResponseDTO, HrAdministrator.class);
    }

    @Override
    public HrAdministrator reqToEntity(HrAdministrationRequestDTO hrAdministrationRequestDTO) {
        return this.modelMapper
                .map(hrAdministrationRequestDTO, HrAdministrator.class);
    }
}
