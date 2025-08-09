package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.CategoryDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Category;
import com.fintech.gestionDeStock.repository.CategoryRespository;
import com.fintech.gestionDeStock.service.CategoryService;
import com.fintech.gestionDeStock.validator.CategoryValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryImpl implements CategoryService{
    private final CategoryRespository categoryRespository;

    @Override
    public void delete(Integer id) {
        if (id == null) {
           return;
        }
        categoryRespository.deleteById(id);   
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRespository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (code == null) {
           return null;
        }
        Optional<Category> category = categoryRespository.findCategoryByCode(code);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(
            ()-> new EntityNotFoundException("la category avec le code"+code+ "n'existe pas dans la BDD", ErrorCode.CATEGORY_NOT_FUND ));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Category> category = categoryRespository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
        new EntityNotFoundException("la category avec l'id"+id+"n'existe pas", ErrorCode.CATEGORY_NOT_FUND));
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Category is not vald", dto);
            throw new InvalidEntityException("la category n'est pas valide", errors, ErrorCode.CATEGORY_NOT_VALID);
        }
        return CategoryDto.fromEntity(categoryRespository.save(CategoryDto.toEntity(dto)));
    }

}
