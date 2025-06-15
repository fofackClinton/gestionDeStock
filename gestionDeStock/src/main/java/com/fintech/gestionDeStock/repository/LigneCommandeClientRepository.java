package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.LigneCommandeClient;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<Integer, LigneCommandeClient> {

}
