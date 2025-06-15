package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.VenteDto;

import ch.qos.logback.core.util.StringUtil;

public class VenteValidator {
    public static List<String> validate(VenteDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner le code de la vente");
            errors.add("veiller renseigner le commantaire de la vente");
            errors.add("veiller renseigner la date de la vente");
            return null;
        }

        if (StringUtil.isNullOrEmpty(dto.getCode())) {
            errors.add("veiller renseigner le code de la vente");
        }

        if (StringUtil.isNullOrEmpty(dto.getCommentaire())) {
            errors.add("veiller renseigner le commantaire de la vente");
        }

        if (StringUtil.isNullOrEmpty(dto.getDateVente().toString())) {
            errors.add("veiller renseigner la date de la vente");
        }

        return errors;
    }

}
