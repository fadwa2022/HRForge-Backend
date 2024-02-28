package com.example.rh.Repository;

import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnelRepository extends JpaRepository<Personnel,String> {
    Optional<Personnel> findByEmail(String email);
    Optional<Personnel> findByUsername(String username);

}
