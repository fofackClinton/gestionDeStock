package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.LigneCommandeFournisseur;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<Integer, LigneCommandeFournisseur> {

}
