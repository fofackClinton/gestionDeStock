package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.CategoryDto;

public interface CategoryService {

  public CategoryDto save(CategoryDto dto);
  
  public CategoryDto findById(Integer id);

  public CategoryDto findByCode(String code);

  public List<CategoryDto> findAll();

  public void delete(Integer id);
}
