package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.ContractResponseDTO;
import com.example.rh.Models.Dtos.Reponse.SalaryResponseDTO;
import com.example.rh.Services.ContratService;
import com.example.rh.Services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/salary")
public class SalaryController {
    private final SalaryService salaryService;


    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/{remunerationDate}")
    public List<SalaryResponseDTO> getSalaryByRemunerationDate(@PathVariable String remunerationDate) {
        return salaryService.getSalaryByRemunerationDate(remunerationDate);

    }
    @GetMapping("/{cin}")
    public List<SalaryResponseDTO> getSalaryByPersonnel(@PathVariable String cin) {
        return salaryService.getSalaryByPersonnel(cin);

    }
    @GetMapping("/{cin}/{remunerationMonth}")
    public SalaryResponseDTO  getTheSalaryOfTheEmployeeOfTheMonth(@PathVariable String cin,@PathVariable String remunerationMonth) {
        return salaryService.getTheSalaryOfTheEmployeeOfTheMonth(cin,remunerationMonth);

    }
    @PostMapping("/{cin}")
    public SalaryResponseDTO updateSalaryMontant (@PathVariable String cin, @RequestParam String salaryMontant) {
        return salaryService.updateSalaryMontant(cin,salaryMontant);

    }
}
