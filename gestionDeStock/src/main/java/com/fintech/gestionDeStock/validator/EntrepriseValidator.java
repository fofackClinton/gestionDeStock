package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.EntrepriseDto;

import ch.qos.logback.core.util.StringUtil;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner le code postale");
            errors.add("veiller renseigner la descvription");
            errors.add("veiller rensigner le mail");
            errors.add("veiller renseigner le nom");
            errors.add("veiller renseigner le numero de telephone de l'entreprise");
            errors.add("veiller renseigner la photos");
            errors.add("veiller renseigner le site web de l'entreprise");
            errors.add("veiller renseigner l'adresse");
            errors.add("veiller rensigner l'utilisateur");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getCodeFiscale())) {
            errors.add("veiller renseigner le code postale");
        }

        if (StringUtil.isNullOrEmpty(dto.getDescription())) {
            errors.add("veiller renseigner la descvription");
        }

        if (StringUtil.isNullOrEmpty(dto.getEmail())) {
            errors.add("veiller rensigner le mail");
        }

        if (StringUtil.isNullOrEmpty(dto.getNom())) {
            errors.add("veiller renseigner le nom");
        }
        if (StringUtil.isNullOrEmpty(dto.getNumeroTelephone())) {
            errors.add("veiller renseigner le numero de telephone de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getPhotos())) {
            errors.add("veiller renseigner la photos");
        }

        if (StringUtil.isNullOrEmpty(dto.getSiteWeb())) {
            errors.add("veiller renseigner le site web de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getAdresse().toString())) {
            errors.add("veiller renseigner l'adresse");
        }

        if (StringUtil.isNullOrEmpty(dto.getUtilisateurs().toString())) {
            errors.add("veiller rensigner l'utilisateur");
        }

        return errors;
    }

}
