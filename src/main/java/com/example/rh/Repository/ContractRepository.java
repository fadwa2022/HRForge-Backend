package com.example.rh.Repository;

import com.example.rh.Models.Entities.Contract;
import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Enum.Contracttype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository

public interface ContractRepository extends JpaRepository<Contract,Long> {
    List<Contract> findByStartcontract(LocalDate startContrat);

    List<Contract> findByEndcontract(LocalDate endContrat);

    List<Contract> findByPersonnel(Personnel personnel);

    List<Contract> findByContractType(Contracttype contracttype);
}
