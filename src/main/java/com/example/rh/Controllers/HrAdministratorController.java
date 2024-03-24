package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.HrAdministrationResponseDTO;
import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Services.HrAdministratorService;
import com.example.rh.Services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hr-administrators")
public class HrAdministratorController {

    private final HrAdministratorService hrAdministratorService;
    private final PersonnelService personnelService;

    @Autowired
    public HrAdministratorController(HrAdministratorService hrAdministratorService ,PersonnelService personnelService) {
        this.hrAdministratorService = hrAdministratorService;
        this.personnelService =personnelService;
    }

    @GetMapping("/{cin}")
    public ResponseEntity<HrAdministrationResponseDTO> getByCin(@PathVariable String  cin) {
        HrAdministrationResponseDTO responseDTO = hrAdministratorService.getByPersonnelCin(cin);

        return responseDTO != null ? ResponseEntity.ok(responseDTO) : ResponseEntity.notFound().build();
    }
    @GetMapping("/personnelusername/{username}")
    public ResponseEntity<HrAdministrationResponseDTO> getByPersonnelUserName(@PathVariable String  username) {
        HrAdministrationResponseDTO responseDTO = hrAdministratorService.getByPersonnelUserName(username);

        return responseDTO != null ? ResponseEntity.ok(responseDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<HrAdministrationResponseDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "5") int size) {
        Page<HrAdministrationResponseDTO> responseDTOPage = hrAdministratorService.getAll(page, size);
        return ResponseEntity.ok(responseDTOPage);
    }

    @PostMapping
    public ResponseEntity<HrAdministrationResponseDTO> create(@RequestBody HrAdministrationRequestDTO requestHrAdministrateur,@RequestBody PersonnelRequestDTO requestPersonnel) {

        personnelService.create(requestPersonnel);

        HrAdministrationResponseDTO responseDTO = hrAdministratorService.create(requestHrAdministrateur);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{cin}")
    public ResponseEntity<HrAdministrationResponseDTO> update(@PathVariable String  cin,
                                                              @RequestBody PersonnelRequestDTO requestDTO) {
       HrAdministrationResponseDTO responseDTO = hrAdministratorService.UpdateHrPersonnel(cin,requestDTO);

        return responseDTO != null ? ResponseEntity.ok(responseDTO) : ResponseEntity.notFound().build();

    }

  /*  @DeleteMapping("/{cin}")
    public ResponseEntity<Void> deleteById(@PathVariable String cin) {
        hrAdministratorService.deleteByPersonnelCin(cin);
        return ResponseEntity.noContent().build();
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        hrAdministratorService.deleteById(id);;
        return ResponseEntity.noContent().build();
    }

}
