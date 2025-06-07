package com.fintech.gestionDeStock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    private List<ArticleDto> article;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryDto.builder()
                .code(category.getCode())
                .designation(category.getDesignation())
                .article(category.getArticle() != null
                        ? category.getArticle().stream().map(ArticleDto::fromEntity).collect(Collectors.toList())
                        : null)
                .build();
    }
 
    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null)
            return null;
        Category category = new Category();
        category.setCode(categoryDto.code);
        category.setDesignation(categoryDto.designation);
        category.setArticle( categoryDto.getArticle().stream().map(ArticleDto::toEntity)
                .collect(Collectors.toList()));
        return category;

    }

}
