package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Reponse.CongeResponseDTO;
import com.example.rh.Models.Dtos.Request.CongeRequestDTO;
import com.example.rh.Services.CongeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conges")
public class CongeController {

    private final CongeService congeService;

    @Autowired
    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }
    @GetMapping("/by-start-date/{startDate}")
    public ResponseEntity<List<CongeResponseDTO>> getCongesByStartDate(@PathVariable String startDate) {
        List<CongeResponseDTO> conges = congeService.getCongeByStartDate(startDate);
        return new ResponseEntity<>(conges, HttpStatus.OK);
    }

    @GetMapping("/by-end-date/{endDate}")
    public ResponseEntity<List<CongeResponseDTO>> getCongesByEndDate(@PathVariable String endDate) {
        List<CongeResponseDTO> conges = congeService.getCongeByEndDate(endDate);
        return new ResponseEntity<>(conges, HttpStatus.OK);
    }

    @GetMapping("/by-personnel/{cin}")
    public ResponseEntity<List<CongeResponseDTO>> getCongesByPersonnel(@PathVariable String cin) {
        List<CongeResponseDTO> conges = congeService.getCongeByPersonnel(cin);
        return new ResponseEntity<>(conges, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CongeResponseDTO>> getAllConges(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(congeService.getAll(page, size).getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CongeResponseDTO> getCongeById(@PathVariable Long id) {
        CongeResponseDTO conge = congeService.getById(id);
        if (conge != null) {
            return new ResponseEntity<>(conge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CongeResponseDTO> createConge(@Valid @RequestBody CongeRequestDTO request) {
        CongeResponseDTO createdConge = congeService.create(request);
        return new ResponseEntity<>(createdConge, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CongeResponseDTO> updateConge(@PathVariable Long id, @Valid @RequestBody CongeRequestDTO request) {
        CongeResponseDTO updatedConge = congeService.update(id.toString(), request);
        if (updatedConge != null) {
            return new ResponseEntity<>(updatedConge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConge(@PathVariable Long id) {
        congeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
