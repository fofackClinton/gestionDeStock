package com.fintech.gestionDeStock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.fintech.gestionDeStock.enums.TypeMvtStk;
import com.fintech.gestionDeStock.models.MvtStk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {
        
    private Integer id;

    private Instant dateMvtStk;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvtStk;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk == null) return null;
        
        return MvtStkDto.builder()
            .dateMvtStk(mvtStk.getDateMvtStk())
            .quantite(mvtStk.getQuantite())
            .article(ArticleDto.fromEntity(mvtStk.getArticle()))
            // .typeMvtStk()
            .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto == null) return null;

        MvtStk mvtStk = new MvtStk();
        mvtStk.setDateMvtStk(mvtStkDto.dateMvtStk);
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.article));
        // mvtStk.setTypeMvtStk(typeMvtStk);
        return mvtStk;
    }

}
