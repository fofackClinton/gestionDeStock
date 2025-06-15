package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.ArticleDto;

import ch.qos.logback.core.util.StringUtil;

public class ArticleValidator {
    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuiller rensegner le prix unitaire");
            errors.add("veuiller rensegner le code de l'article");
            errors.add("veuiller rensegner la designation");
            errors.add("veuiller rensegner le Taux tva");
            errors.add("veuiller rensegner le prix unitaire");
            errors.add("veuiller rensegner la photo");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getPrixUnitaireHt().toString())) {
            errors.add("veuiller rensegner le prix unitaire");
        }

        if (StringUtil.isNullOrEmpty(dto.getCodeArticle())) {
            errors.add("veuiller rensegner le code de l'article");
        }

        if (StringUtil.isNullOrEmpty(dto.getDesignation())) {
            errors.add("veuiller rensegner la designation");
        }

        if (StringUtil.isNullOrEmpty(dto.getCategory().toString())) {
            errors.add("veuiller rensegner la catégorie");
        }
        if (StringUtil.isNullOrEmpty(dto.getTauxTva().toString())) {
            errors.add("veuiller rensegner le Taux tva");
        }
        if (StringUtil.isNullOrEmpty(dto.getPrixUnitaireTtc().toString())) {
            errors.add("veuiller rensegner le prix unitaire");
        }

        if (StringUtil.isNullOrEmpty(dto.getPhoto())) {
            errors.add("veuiller rensegner la photo");
        }

        return errors;
    }

}
