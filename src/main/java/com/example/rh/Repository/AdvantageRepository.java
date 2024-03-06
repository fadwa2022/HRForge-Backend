package com.example.rh.Repository;

import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Entities.Advantage;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository

public interface AdvantageRepository extends JpaRepository<Advantage,Long> {
    List<Advantage> findByRemunerationdate(LocalDate remunerationdate);
    List<Advantage> findByEmployee(Personnel employee);
    List<Advantage> findByEmployeeAndRemunerationdate(Personnel employee, LocalDate remunerationdate);

}
