package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer>{

}
