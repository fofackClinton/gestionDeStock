package com.fintech.gestionDeStock.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fintech.gestionDeStock.controllers.api.ArticleApi;
import com.fintech.gestionDeStock.dto.ArticleDto;
import com.fintech.gestionDeStock.service.ArticleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Override
    public void delete(Integer id) {
        articleService.delete(id);

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {

        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {

        return articleService.findById(id);
    }

    @Override
    public ArticleDto save(ArticleDto dto) {

        return articleService.save(dto);
    }
}
