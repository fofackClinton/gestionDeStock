package com.fintech.gestionDeStock.dto;

import java.math.BigDecimal;

import com.fintech.gestionDeStock.models.Article;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        return ArticleDto.builder()
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .category(article.getCategory() != null ? CategoryDto.fromEntity(article.getCategory())
                        : null)
                .build();

    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setCodeArticle(articleDto.codeArticle);
        article.setDesignation(articleDto.designation);
        article.setPrixUnitaireHt(articleDto.prixUnitaireHt);
        article.setTauxTva(articleDto.tauxTva);
        article.setPrixUnitaireTtc(articleDto.prixUnitaireTtc);
        article.setPhoto(articleDto.photo);
        article.setCategory(articleDto.getCategory() != null ? CategoryDto.toEntity(articleDto.getCategory())
                : null);
        return article;
    }

}
