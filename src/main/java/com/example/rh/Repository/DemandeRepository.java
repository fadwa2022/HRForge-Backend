package com.example.rh.Repository;

import com.example.rh.Models.Entities.Demande;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByPersonnelCin(String cin);


    //
}
