package com.example.rh.Repository;

import com.example.rh.Models.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate,String> {
}
