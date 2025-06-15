package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseur extends JpaRepository<Integer, com.fintech.gestionDeStock.models.CommandeFournisseur > {

}
