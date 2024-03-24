package com.example.rh.Services;

import com.example.rh.Models.Dtos.Reponse.SalaryResponseDTO;
import com.example.rh.Models.Dtos.Request.SalaryRequestDTO;
import com.example.rh.Models.Entities.Salary;

import java.util.List;

public interface SalaryService extends Service<Salary,Long, SalaryRequestDTO, SalaryResponseDTO> {
    List<SalaryResponseDTO> getSalaryByRemunerationDate(String remunerationDate);

    List<SalaryResponseDTO> getSalaryByPersonnel(String cin);

    SalaryResponseDTO getTheSalaryOfTheEmployeeOfTheMonth(String cin, String remunerationMonth);

    SalaryResponseDTO updateSalaryMontant(String cin, String salaryMontant);
}
