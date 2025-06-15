package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.UtilisateurDto;

import ch.qos.logback.core.util.StringUtil;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner le mail de l'utilisateur");
            errors.add("veiller renseigner le nom de l'utilisateur");
            errors.add("veiller renseigner le mot de passe de l'utilisateur");
            errors.add("veiller renseigner la photo de l'utilisateur");
            errors.add("veiller renseigner le prenom de l'utilisateur");
            errors.add("veiller renseigner l'adresse de l'utilisateur");
            errors.add("veiller renseigner la date naissance de l'utilisateur");
            errors.add("veiller renseigner l'entreprise de l'utilisateur");
            errors.add("veiller renseigner le role de l'utilisateur");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getEmail())) {
            errors.add("veiller renseigner le mail de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getNom())) {
            errors.add("veiller renseigner le nom de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getPassword())) {
            errors.add("veiller renseigner le mot de passe de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getPhoto())) {
            errors.add("veiller renseigner la photo de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getPrenom())) {
            errors.add("veiller renseigner le prenom de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getAdresse().toString())) {
            errors.add("veiller renseigner l'adresse de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getDateNaissance().toString())) {
            errors.add("veiller renseigner la date naissance de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getEntreprise().toString())) {
            errors.add("veiller renseigner l'entreprise de l'utilisateur");
        }

        if (StringUtil.isNullOrEmpty(dto.getRoles().toString())) {
            errors.add("veiller renseigner le role de l'utilisateur");
        }
        
        return errors;
    }

}
