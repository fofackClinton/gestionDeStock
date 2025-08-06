package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.ArticleDto;

public interface ArticleService {
    
    public ArticleDto save(ArticleDto dto);

    public ArticleDto findById(Integer id);

    public ArticleDto findByCodeArticle(String codeArticle);
    
    public List<ArticleDto> findAll();

    public void delete(Integer id);
}
