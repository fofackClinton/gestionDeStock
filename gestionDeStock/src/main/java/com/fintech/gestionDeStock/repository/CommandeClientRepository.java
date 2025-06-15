package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.CommandeClient;

@Repository
public interface CommandeClientRepository extends JpaRepository<Integer, CommandeClient> {

}
