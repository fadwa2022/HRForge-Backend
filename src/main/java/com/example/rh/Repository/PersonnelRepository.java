package com.example.rh.Repository;

import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface PersonnelRepository extends JpaRepository<Personnel,String> {
    Optional<Personnel> findByEmail(String email);
    Optional<Personnel> findByUsername(String username);

    Optional<Personnel> findByCin(String cin);

}
