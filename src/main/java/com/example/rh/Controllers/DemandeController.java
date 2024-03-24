package com.example.rh.Controllers;

import com.example.rh.Models.Dtos.Reponse.DemandeResponse;
import com.example.rh.Models.Dtos.Request.Demanderequest;
import com.example.rh.Models.Entities.Demande;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.MessageStatut;
import com.example.rh.Repository.PersonnelRepository;
import com.example.rh.Services.Impl.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    private PersonnelRepository personnelRepository;
    private final DemandeService demandeService;

    @Autowired
    public DemandeController( PersonnelRepository personnelRepository,DemandeService demandeService) {
        this.demandeService = demandeService;
        this.personnelRepository = personnelRepository;
    }

    @GetMapping
    public List<DemandeResponse> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        Demande demande = demandeService.getDemandeById(id);
        return ResponseEntity.ok(demande);
    }
    @GetMapping("/personnel/{cin}")
    public List<DemandeResponse> getDemandeByPersonnel(@PathVariable String cin) {
        return demandeService.getDemandeByPersonnel(cin);
    }
    @PostMapping
    public DemandeResponse createDemande(@RequestBody Demanderequest demande) {
        Optional<Personnel> personnelOptional = personnelRepository.findByCin(demande.getPersonnel());
        if (personnelOptional.isPresent()) {
            Demande demande1 = new Demande();
            demande1.setPersonnel(personnelOptional.get());
            demande1.setContent(demande.getContent());
            demande1.setStatut(MessageStatut.valueOf(demande.getStatut()));
            demande1.setSubject(demande.getSubject());

            return  demandeService.createDemande(demande1);
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable Long id, @RequestBody Demande demandeDetails) {
        Demande updatedDemande = demandeService.updateDemande(id, demandeDetails);
        return ResponseEntity.ok(updatedDemande);
    }

    @PutMapping("/updatestatut/{id}/{statut}")
    public Demande updateDemandeStatut(@PathVariable Long id, @PathVariable String statut) {
       return demandeService.updateDemandeStatut(id, statut);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
        return ResponseEntity.noContent().build();
    }
}

