package com.fintech.gestionDeStock.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="article")
public class Article extends AbstractEntity {
    @Column(name="code_article", nullable=false)
    private String codeArticle;

    @Column(name="designation", nullable=false)
    private String Designation;

    @Column(name="prix_unitaire_ht", nullable=false)
    private BigDecimal prixUnitaireHt;

    @Column(name="taux_tva", nullable=false)
    private BigDecimal tauxTva;

    @Column(name="prix_unitaire_ttc", nullable=false)
    private BigDecimal prixUnitaireTtc;

    @Column(name="photo", nullable=false)
    private String photo;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Category category;

}
