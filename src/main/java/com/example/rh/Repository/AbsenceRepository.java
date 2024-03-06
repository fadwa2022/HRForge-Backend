package com.example.rh.Repository;

import com.example.rh.Models.Entities.Absence;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findByPersonnel(Personnel personnel);
    List<Absence> findByMissingdate(String missingDate);

}
