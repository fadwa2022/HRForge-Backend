package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.PersonnelResponseDTO;
import com.example.rh.Models.Dtos.Request.PersonnelRequestDTO;
import com.example.rh.Services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {

    private final PersonnelService personnelService;

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping("/{cin}")
    public PersonnelResponseDTO getById(@PathVariable String cin) {
        return personnelService.getById(cin);
    }


    @GetMapping("/username/{username}")
    public PersonnelResponseDTO getByUserName(@PathVariable String username) {
        return personnelService.GetPersonnelByUserName(username);
    }

    @GetMapping
  //  @PreAuthorize("hasAuthority('SCOPE_ROLE_MEMBER') or hasAuthority('SCOPE_ROLE_JURY')")
    @PreAuthorize("permitAll()")
    public Page<PersonnelResponseDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        return personnelService.getAll(page, size);
    }

    @PostMapping
    public PersonnelResponseDTO create(@RequestBody PersonnelRequestDTO request) {
        return personnelService.create(request);
    }

    @PutMapping("/{cin}")
    public PersonnelResponseDTO update(@PathVariable String cin,
                                       @RequestBody PersonnelRequestDTO request) {
        return personnelService.update(cin, request);
    }

    @DeleteMapping("/{cin}")
    public void deleteById(@PathVariable String cin) {
        personnelService.deleteById(cin);
    }
}
