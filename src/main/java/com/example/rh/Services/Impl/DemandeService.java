package com.example.rh.Services.Impl;

import com.example.rh.Models.Dtos.Reponse.DemandeResponse;
import com.example.rh.Models.Entities.Demande;
import com.example.rh.Models.Enum.MessageStatut;
import com.example.rh.Models.Mappers.DemandeMapper;
import com.example.rh.Repository.DemandeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private final DemandeMapper demandeMapper;

    @Autowired
    public DemandeService(DemandeMapper demandeMapper,DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper =demandeMapper;
    }

    public List<DemandeResponse> getAllDemandes() {
        return demandeRepository.findAll()
                .stream()
                .map(demandeMapper::toRes)
                .collect(Collectors.toList());
    }

    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande not found with id: " + id));
    }

    public List<DemandeResponse> getDemandeByPersonnel(String cin) {
        return demandeRepository.findByPersonnelCin(cin)
                .stream()
                .map(demandeMapper::toRes)
                .collect(Collectors.toList());
    }


    public DemandeResponse createDemande(Demande demande) {
        return  demandeMapper.toRes(demandeRepository.save(demande));
    }

    public Demande updateDemande(Long id, Demande demandeDetails) {
        Demande demande = getDemandeById(id);
        demande.setSubject(demandeDetails.getSubject());
        demande.setContent(demandeDetails.getContent());
        demande.setStatut(demandeDetails.getStatut());
        return demandeRepository.save(demande);
    }
    public Demande updateDemandeStatut(Long id, String statut) {
        Demande demande = getDemandeById(id);
        demande.setStatut(MessageStatut.valueOf(statut));
        demande.setSubject(demande.getSubject());
        demande.setContent(demande.getContent());
        return demandeRepository.save(demande);
    }
    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}
