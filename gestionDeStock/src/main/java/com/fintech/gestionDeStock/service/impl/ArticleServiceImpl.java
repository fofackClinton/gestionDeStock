package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.ArticleDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Article;
import com.fintech.gestionDeStock.repository.ArticleRepository;
import com.fintech.gestionDeStock.service.ArticleService;
import com.fintech.gestionDeStock.validator.ArticleValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class  ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto dto){
        List<String> errors = ArticleValidator.validate(dto);
        if (errors.isEmpty()) {
            log.error("Article is not valid", dto);
            throw new InvalidEntityException("L'article n'est pas valide",  errors, ErrorCode.ARTICLE_NOT_VALID);
        }
        return ArticleDto.fromEntity(
            articleRepository.save(ArticleDto.toEntity(dto))
        );
    }

    @Override
    public ArticleDto findById(Integer id){
        if (id == null) {
            return null;   
        }
        Optional<Article> article = articleRepository.findById(id);
        
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
            new EntityNotFoundException("L\'article avec l'id "+ id+ "n'existe pas dans la BDD",ErrorCode.ARTICLE_NOT_FUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle){
        if (codeArticle == null) {
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
            new EntityNotFoundException("L'article avec le code "+ codeArticle+ "n'existe pas", ErrorCode.ARTICLE_NOT_FUND)
        );
    }
    
    @Override
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if (id == null) {
            return;
        }
        articleRepository.deleteById(id);
        
    }

}
