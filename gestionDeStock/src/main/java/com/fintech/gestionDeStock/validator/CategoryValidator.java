package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.CategoryDto;

import ch.qos.logback.core.util.StringUtil;

public class CategoryValidator {
    public static List<String> validate(CategoryDto dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("veiller renseigner le code de la category");
            errors.add("veiller renseigner la designation de la categorie");
            errors.add("veiller rensegner l'article");
            return errors;
        }
        if (StringUtil.isNullOrEmpty(dto.getCode())) {
            errors.add("veiller renseigner le code de la category");
        }
        if (StringUtil.isNullOrEmpty(dto.getDesignation())) {
            errors.add("veiller renseigner la designation de la categorie");
        }

        if (StringUtil.isNullOrEmpty(dto.getArticle().toString())) {
            errors.add("veiller rensegner l'article");    
        }
        return errors;
    }

}
