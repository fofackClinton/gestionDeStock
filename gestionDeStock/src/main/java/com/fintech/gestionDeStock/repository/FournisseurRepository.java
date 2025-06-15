package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {

}
