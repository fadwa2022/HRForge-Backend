package com.example.rh.Repository;

import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findByPersonnelCin(String cin);

    List<Absence> findByMissingdate(LocalDate missingDate);

}
