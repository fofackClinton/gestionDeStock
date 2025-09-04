package com.fintech.gestionDeStock.dto;

import java.time.Instant;
import java.util.List;

import com.fintech.gestionDeStock.models.Ventes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVenteDto> ligneVentes;

    public static VenteDto fromEntity(Ventes vente) {
        if (vente == null)
            return null;

        return VenteDto.builder()
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VenteDto venteDto) {
        if (venteDto == null)
            return null;

        Ventes vente = new Ventes();
        vente.setCode(venteDto.code);
        vente.setDateVente(venteDto.dateVente);
        vente.setCommentaire(venteDto.commentaire);
        return vente;
    }

}
