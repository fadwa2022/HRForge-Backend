package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Services.AdvantageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/advantages")
public class AdvantageController {

    @Autowired
    private AdvantageService advantageService;

    @GetMapping("/by-remuneration-date/{date}")
    public ResponseEntity<List<AdvantageResponseDTO>> getAdvantagesByRemunerationDate(@PathVariable String date) {
        List<AdvantageResponseDTO> advantages = advantageService.getAdvantageByRemunerationdate(date);
        return new ResponseEntity<>(advantages, HttpStatus.OK);
    }

    @GetMapping("/by-personnel/{cin}")
    public ResponseEntity<List<AdvantageResponseDTO>> getAdvantagesByPersonnel(@PathVariable String cin) {
        List<AdvantageResponseDTO> advantages = advantageService.getAdvantageByPersonnel(cin);
        return new ResponseEntity<>(advantages, HttpStatus.OK);
    }

    @GetMapping("/by-personnel-and-date/{cin}/{date}")
    public ResponseEntity<List<AdvantageResponseDTO>> getAdvantagesByPersonnelAndDate(@PathVariable String cin, @PathVariable String date) {
        List<AdvantageResponseDTO> advantages = advantageService.getAdvantageByPersonnelAndRemunerationDate(cin, date);
        return new ResponseEntity<>(advantages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvantageResponseDTO> getAdvantageById(@PathVariable Long id) {
        AdvantageResponseDTO advantage = advantageService.getById(id);
        return advantage != null ? new ResponseEntity<>(advantage, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<AdvantageResponseDTO> createAdvantage(@Valid @RequestBody AdvantageRequestDTO request) {
        AdvantageResponseDTO advantage = advantageService.create(request);
        return new ResponseEntity<>(advantage, HttpStatus.CREATED);
    }

}