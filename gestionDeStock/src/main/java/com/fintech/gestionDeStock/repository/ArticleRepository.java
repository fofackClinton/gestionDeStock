package com.fintech.gestionDeStock.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import com.fintech.gestionDeStock.models.Article;

@Repository
public interface ArticleRepository extends JpaAttributeConverter<Article, Integer> {

}
