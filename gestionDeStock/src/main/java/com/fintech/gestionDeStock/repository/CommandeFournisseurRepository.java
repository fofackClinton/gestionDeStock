package com.fintech.gestionDeStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.CommandeFournisseur;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
