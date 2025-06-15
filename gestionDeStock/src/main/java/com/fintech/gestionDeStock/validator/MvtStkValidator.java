package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.MvtStkDto;

import ch.qos.logback.core.util.StringUtil;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner l'article");
            errors.add("veiller renseigner la date du mouvement de stock");
            errors.add("veiller renseigner la quantité");
            errors.add("veiller renseigner le type de mouvement de stock");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getArticle().toString())) {
            errors.add("veiller renseigner l'article");
        }
        if (StringUtil.isNullOrEmpty(dto.getDateMvtStk().toString())) {
            errors.add("veiller renseigner la date du mouvement de stock");
        }

        if (dto.getQuantite() == null) {
            errors.add("veiller renseigner la quantité");
        }

        if (StringUtil.isNullOrEmpty(dto.getTypeMvtStk().toString())) {
            errors.add("veiller renseigner le type de mouvement de stock");
        }

        return errors;
    }

}
