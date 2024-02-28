package com.example.rh.Repository;

import com.example.rh.Models.Entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
