package com.fintech.gestionDeStock.dto;

import java.time.Instant;

import com.fintech.gestionDeStock.models.Vente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public static VenteDto fromEntity(Vente vente) {
        if (vente == null)
            return null;

        return VenteDto.builder()
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto) {
        if (venteDto == null)
            return null;

        Vente vente = new Vente();
        vente.setCode(venteDto.code);
        vente.setDateVente(venteDto.dateVente);
        vente.setCommentaire(venteDto.commentaire);
        return vente;
    }

}
