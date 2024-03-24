package com.example.rh.Repository;

import com.example.rh.Models.Entities.HrAdministrator;
import com.example.rh.Models.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface HrAdministratorRepository extends JpaRepository<HrAdministrator,Long> {
    Optional<HrAdministrator> findByPersonnelCin(String cin);
    Optional<HrAdministrator> findByPersonnelUsername(String username);

    boolean existsByPersonnelEmail(String email);
    void deleteByPersonnelCin(String cin);
    void deleteById(Long id);

}
