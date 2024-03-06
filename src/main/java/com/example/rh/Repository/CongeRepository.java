package com.example.rh.Repository;

import com.example.rh.Models.Dtos.Reponse.CongeResponseDTO;
import com.example.rh.Models.Entities.Conge;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {
    List<Conge> findByStartDate(LocalDate startDate);
    List<Conge> findByEndDate(LocalDate endDate);
    List<Conge> findByPersonnel (Personnel personnel);
}
