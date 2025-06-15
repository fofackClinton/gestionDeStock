package com.fintech.gestionDeStock.validator;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.dto.CommandeClientDto;

import ch.qos.logback.core.util.StringUtil;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veiller renseigner le code de la commande client");
            errors.add("veiller renseigner le client concerner par mla commande");
            errors.add("veiller renseigner la date de commande");
            errors.add("veiller renseigner la ligne commande du client");
            return errors;
        }

        if (StringUtil.isNullOrEmpty(dto.getCode())) {
            errors.add("veiller renseigner le code de la commande client");
        }

        if (StringUtil.isNullOrEmpty(dto.getClient().toString())) {
            errors.add("veiller renseigner le client concerner par mla commande");
        }

        if (StringUtil.isNullOrEmpty(dto.getDateCommande().toString())) {
            errors.add("veiller renseigner la date de commande");
        }

        if (StringUtil.isNullOrEmpty(dto.getLigneCommandeClients().toString())) {
            errors.add("veiller renseigner la ligne commande du client");
        }

        return errors;
    }

}
