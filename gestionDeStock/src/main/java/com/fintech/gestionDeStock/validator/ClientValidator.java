package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;


import com.fintech.gestionDeStock.dto.ClientDto;

import ch.qos.logback.core.util.StringUtil;

public class ClientValidator {
    public static List<String> validate(ClientDto dto){
        List<String> errors = new ArrayList<>();
        
        if (dto == null) {
            errors.add("veiller entrer le nom");
            errors.add("veiller rensegner le numero de téléphone du client");
            errors.add("veiller le prenom du client");
            errors.add("veiller renseigner l'address mail du client");
            errors.add("veiller renseigner la commande client");
            return errors;
        }

        if(StringUtil.isNullOrEmpty(dto.getNom())){
            errors.add("veiller entrer le nom");
        }

        if (StringUtil.isNullOrEmpty(dto.getNumTel())) {
            errors.add("veiller rensegner le numero de téléphone du client");
        }

        if(StringUtil.isNullOrEmpty(dto.getPhoto())){
            errors.add("veiller le prenom du client");
        }

        if(StringUtil.isNullOrEmpty(dto.getMail())){
            errors.add("veiller renseigner l'address mail du client");
        }

        if(StringUtil.isNullOrEmpty(dto.getAdresse().toString())){
            errors.add("veiller renseigner l'adresse du client");
        }

        if(StringUtil.isNullOrEmpty(dto.getCommandeClients().toString())){
            errors.add("veiller renseigner la commande client");
        }
        return errors;

    }

}
