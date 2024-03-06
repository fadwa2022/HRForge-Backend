package com.example.rh.Repository;

import com.example.rh.Models.Entities.HrAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface HrAdministratorRepository extends JpaRepository<HrAdministrator,String> {
    Optional<HrAdministrator> findByCin(String cin);
    boolean existsByEmail(String email);

}
