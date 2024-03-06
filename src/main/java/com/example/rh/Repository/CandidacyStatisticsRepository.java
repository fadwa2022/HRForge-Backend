package com.example.rh.Repository;

import com.example.rh.Models.Entities.CandidacyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidacyStatisticsRepository extends JpaRepository<CandidacyStatistics,Long> {
}
