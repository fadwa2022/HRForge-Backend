package com.example.rh.Repository;

import com.example.rh.Models.Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
