package com.example.rh.Repository;

import com.example.rh.Models.Entities.Personnel;
import com.example.rh.Models.Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface SalaryRepository extends JpaRepository<Salary,Long> {
    List<Salary> findByRemunerationdate(LocalDate remunerationdate);

    List<Salary> findByEmployee(Personnel employee);

    Salary findByEmployeeAndRemunerationdate(Personnel employee, LocalDate remunerationdate);

}
