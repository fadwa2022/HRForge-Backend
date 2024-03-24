package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.ContractResponseDTO;
import com.example.rh.Models.Dtos.Request.ContractRequestDTO;
import com.example.rh.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContratController {
    private final ContratService contratService;

    @Autowired
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping("/startContrat/{startContrat}")
    public List<ContractResponseDTO> getContractByStartContract(@PathVariable String startContrat) {
        return contratService.getContractByStartContract(startContrat);
    }

    @GetMapping("/endContract/{endContract}")
    public List<ContractResponseDTO> getContratByEndContract(@PathVariable String endDate) {
        return contratService.getContratByEndContract(endDate);

    }

    @GetMapping("/personnel/{cin}")
    public List<ContractResponseDTO> getContratByPersonnel (@PathVariable String cin) {
        return contratService.getContratByPersonnel(cin);

    }

    @GetMapping("/contractType/{contractType}")
    public List<ContractResponseDTO> getContratByContractType (@PathVariable String contractType) {
        return contratService.getContratByContractType(contractType);

    }

    @PostMapping ("/{cin}")
    public ContractResponseDTO updateContractType (@PathVariable String cin, @RequestParam String contractType) {
        return contratService.updateContractType(cin,contractType);

    }

    @GetMapping("/{id}")
    public ContractResponseDTO getById(@PathVariable Long id) {
            return contratService.getById(id);
        }

    @GetMapping
    public Page<ContractResponseDTO> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
            return contratService.getAll(page, size);
        }

    @PostMapping
    public ContractResponseDTO create(@RequestBody ContractRequestDTO request) {
            return contratService.create(request);
        }

    @PutMapping("/{id}")
    public ContractResponseDTO update(@PathVariable String id, @RequestBody ContractRequestDTO request) {
            return contratService.update(id, request);
        }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
            contratService.deleteById(id);
        }




    }
