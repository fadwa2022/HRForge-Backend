package com.example.rh.Repository;

import com.example.rh.Models.Entities.Generaladministration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GeneraladministrationRepository extends JpaRepository<Generaladministration,Long> {
}
