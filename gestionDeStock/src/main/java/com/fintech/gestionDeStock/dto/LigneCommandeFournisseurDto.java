package com.fintech.gestionDeStock.dto;

import java.math.BigDecimal;

import com.fintech.gestionDeStock.models.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantité;

    private BigDecimal prixUnitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null)
            return null;

        return LigneCommandeFournisseurDto.builder()
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .commandeFournisseur(
                        CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .quantité(ligneCommandeFournisseur.getQuantité())
                .prixUnitaire(ligneCommandeFournisseur.getQuantité())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null)
            return null;

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.article));
        ligneCommandeFournisseur.setCommandeFournisseur(
                CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.commandeFournisseur));
        ligneCommandeFournisseur.setQuantité(ligneCommandeFournisseurDto.quantité);
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.prixUnitaire);
        return ligneCommandeFournisseur;
    }

}
