package com.fintech.gestionDeStock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null)
            return null;

        return CommandeFournisseurDto.builder()
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(commandeFournisseur.getFournisseur() == null
                        ? FournisseurDto.fromEntity(commandeFournisseur.getFournisseur())
                        : null)
                .ligneCommandeFournisseurs(
                        commandeFournisseur.getLigneCommandeFournisseurs() == null
                                ? commandeFournisseur.getLigneCommandeFournisseurs().stream()
                                        .map(LigneCommandeFournisseurDto::fromEntity).collect(Collectors.toList())
                                : null)
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null)
            return null;

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setCode(commandeFournisseurDto.code);
        commandeFournisseur.setDateCommande(commandeFournisseurDto.dateCommande);
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.fournisseur));
        commandeFournisseur.setLigneCommandeFournisseurs(commandeFournisseurDto.ligneCommandeFournisseurs == null
                ? commandeFournisseurDto.ligneCommandeFournisseurs.stream().map(LigneCommandeFournisseurDto::toEntity)
                        .collect(Collectors.toList())
                : null);
        return commandeFournisseur;
    }

}
