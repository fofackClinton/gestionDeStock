package com.fintech.gestionDeStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {

}
