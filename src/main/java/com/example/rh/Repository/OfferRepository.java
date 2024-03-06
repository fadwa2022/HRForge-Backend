package com.example.rh.Repository;

import com.example.rh.Models.Entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
