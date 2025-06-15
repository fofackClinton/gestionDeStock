package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.CommandeFournisseurDto;

import ch.qos.logback.core.util.StringUtil;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getCode())) {
            errors.add("veiller renseigner le code");
        }

        if (StringUtil.isNullOrEmpty(dto.getDateCommande().toString())) {
            errors.add("veiller renseigner la date de la commande du furnisseur");
        }

        if (StringUtil.isNullOrEmpty(dto.getFournisseur().toString())) {
            errors.add("veiller le forunisseur");
        }

        if (StringUtil.isNullOrEmpty(dto.getLigneCommandeFournisseurs().toString())) {
            errors.add("veiller renseigner la ligne commande du fournisseur");
        }

        return errors;
    }

}
