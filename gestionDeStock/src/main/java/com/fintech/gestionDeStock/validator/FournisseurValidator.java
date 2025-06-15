package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.FournisseurDto;

import ch.qos.logback.core.util.StringUtil;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto dto) {
        
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner le mail de l'entreprise");
            errors.add("veiller renseigner le nom de l'entreprise");
            errors.add("veiller renseigner le numero de telephone de l'entreprise");
            errors.add("veiller renseigner la photo de l'entreprise");
            errors.add("veiller renseigner le prenom de l'entreprise");
            errors.add("veiller renseigner l'adresse de l'entreprise");
            errors.add("veiller renseigner les commande fournisseur de l'entreprise");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getMail())) {
            errors.add("veiller renseigner le mail de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getNom())) {
            errors.add("veiller renseigner le nom de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getNumTel())) {
            errors.add("veiller renseigner le numero de telephone de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getPhoto())) {
            errors.add("veiller renseigner la photo de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getPrenom())) {
            errors.add("veiller renseigner le prenom de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getAdresse().toString())) {
            errors.add("veiller renseigner l'adresse de l'entreprise");
        }

        if (StringUtil.isNullOrEmpty(dto.getCommandeFournisseurs().toString())) {
            errors.add("veiller renseigner les commande fournisseur de l'entreprise");
        }

        return errors;
    }

}
