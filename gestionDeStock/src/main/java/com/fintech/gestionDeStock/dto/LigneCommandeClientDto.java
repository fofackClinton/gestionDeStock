package com.fintech.gestionDeStock.dto;

import java.math.BigDecimal;

import com.fintech.gestionDeStock.models.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {
        
    private Integer id;

    private ArticleDto article;

    private  CommandeClientDto commandeClient;

    private BigDecimal quantité;

    private BigDecimal prixUnitaire;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient == null ) return null;

        return LigneCommandeClientDto.builder()
            .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
            .commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
            .quantité(ligneCommandeClient.getQuantité())
            .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
            .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto == null) return null;
        
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.article));
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.commandeClient));
        ligneCommandeClient.setQuantité(ligneCommandeClientDto.quantité);
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.prixUnitaire);
        return ligneCommandeClient;
    }

}
