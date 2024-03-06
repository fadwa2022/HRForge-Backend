package com.example.rh.Repository;

import com.example.rh.Models.Entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
