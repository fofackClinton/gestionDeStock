package com.fintech.gestionDeStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCode(String code); 
}
