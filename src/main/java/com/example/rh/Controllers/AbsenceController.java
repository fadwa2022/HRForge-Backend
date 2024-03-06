package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;
import com.example.rh.Models.Dtos.Request.AbsenceRequestDTO;
import com.example.rh.Models.suppl.AbsenceResponse;
import com.example.rh.Services.AbsenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/{id}")
    public AbsenceResponseDTO getAbsenceById(@PathVariable Long id) {
        return absenceService.getById(id);
    }

    @GetMapping("/{cin}")
    public List<AbsenceResponseDTO> getAbsenceByPersonnel(@PathVariable String cin) {
        return absenceService.getAbsenceByPersonnel(cin);
    }
    @GetMapping("/{cin}/{missingMonth}")
    public AbsenceResponse getAbsenceByPersonnelAndMissingDate(@PathVariable String cin, @PathVariable String missingMonth) {
        return absenceService.getAbsenceByPersonnelAndMissingDate(cin,missingMonth);
    }

    @GetMapping("/{missingDate}")
    public List<AbsenceResponseDTO> getAbsenceByMissingDate(@PathVariable String missingDate) {
        return absenceService.getAbsenceByMissingDate(missingDate);
    }

    @GetMapping
    public Page<AbsenceResponseDTO> getAllAbsences(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return absenceService.getAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AbsenceResponseDTO createAbsence(@Valid @RequestBody AbsenceRequestDTO request) {
        return absenceService.create(request);
    }

    @PutMapping("/{id}")
    public AbsenceResponseDTO updateAbsence(@PathVariable Long id,
                                            @Valid @RequestBody AbsenceRequestDTO request) {
        return null; // Replace with actual implementation
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAbsence(@PathVariable Long id) {
        absenceService.deleteById(id);
    }
}
