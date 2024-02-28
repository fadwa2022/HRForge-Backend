package com.example.rh.Repository;

import com.example.rh.Models.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,String> {
}
