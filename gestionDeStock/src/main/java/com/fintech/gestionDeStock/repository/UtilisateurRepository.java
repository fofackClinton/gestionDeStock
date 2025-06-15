package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Integer, Utilisateur> {

}
