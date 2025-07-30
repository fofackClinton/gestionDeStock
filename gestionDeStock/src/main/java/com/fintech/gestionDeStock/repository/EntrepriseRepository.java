package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
