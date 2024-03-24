package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.SalaryResponseDTO;
import com.example.rh.Models.Dtos.Request.SalaryRequestDTO;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Entities.Salary;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Repository.SalaryRepository;
import com.example.rh.Services.SalaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final PersonnelRepository personnelRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository,PersonnelRepository personnelRepository) {
        this.salaryRepository = salaryRepository;
        this.personnelRepository =personnelRepository;
    }

    @Override
    public List<SalaryResponseDTO> getSalaryByRemunerationDate(String remunerationDate) {
        List<Salary> salaries = salaryRepository.findByRemunerationdate(LocalDate.parse(remunerationDate));
        return salaries.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalaryResponseDTO> getSalaryByPersonnel(String cin) {
        Personnel personnel = personnelRepository.findByCin(cin).get();
        List<Salary> salaries = salaryRepository.findByEmployee(personnel);
        return salaries.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalaryResponseDTO getTheSalaryOfTheEmployeeOfTheMonth(String cin, String remunerationMonth) {
        Personnel personnel = personnelRepository.findByCin(cin).get();
        Salary salary = salaryRepository.findByEmployeeAndRemunerationdate(personnel, LocalDate.parse(remunerationMonth));
        return convertToResponseDTO(salary);
    }

    @Override
    public SalaryResponseDTO updateSalaryMontant(String cin, String salaryMontant) {
        SalaryResponseDTO salary = this.getTheSalaryOfTheEmployeeOfTheMonth(cin, salaryMontant);
    //    salary.setMontant(salaryMontant);
      //  salaryRepository.save(salary);
        //return convertToResponseDTO(salary);
        return null;
    }

    @Override
    public SalaryResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public Page<SalaryResponseDTO> getAll(int page, int size) {
        return null;
    }

    @Override
    public SalaryResponseDTO create(SalaryRequestDTO requestDTO) {
        Salary salary = new Salary();
        BeanUtils.copyProperties(requestDTO, salary);
        Salary savedSalary = salaryRepository.save(salary);
        return convertToResponseDTO(savedSalary);
    }

    @Override
    public SalaryResponseDTO update(String id, SalaryRequestDTO request) {
        return null;
    }


    private SalaryResponseDTO convertToResponseDTO(Salary salary) {
        SalaryResponseDTO responseDTO = new SalaryResponseDTO();
        BeanUtils.copyProperties(salary, responseDTO);
        return responseDTO;
    }


    @Override
    public void deleteById(Long id) {
        salaryRepository.deleteById(id);
    }
}
