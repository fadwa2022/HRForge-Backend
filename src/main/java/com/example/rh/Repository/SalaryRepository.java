package com.example.rh.Repository;

import com.example.rh.Models.Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
