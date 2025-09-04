package com.fintech.gestionDeStock.dto;

import java.math.BigDecimal;

import com.fintech.gestionDeStock.models.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private VenteDto vente;
    
    private ArticleDto article;

    private BigDecimal quantité;

    private BigDecimal prixUnitaire;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null)
            return null;

        return LigneVenteDto.builder()
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantité(ligneVente.getQuantité())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null)
            return null;

        LigneVente ligneVente = new LigneVente();
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.vente));
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.article));
        ligneVente.setQuantité(ligneVenteDto.quantité);
        ligneVente.setPrixUnitaire(ligneVenteDto.prixUnitaire);
        return ligneVente;
    }

}
