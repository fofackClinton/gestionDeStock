package com.fintech.gestionDeStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Ventes;

@Repository
public interface VenteRepository extends JpaRepository<Ventes, Integer>{
    Optional<Ventes> findVenteByCode(String code);
}
