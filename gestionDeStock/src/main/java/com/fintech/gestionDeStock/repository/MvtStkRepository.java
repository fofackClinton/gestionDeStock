package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.MvtStk;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

}
