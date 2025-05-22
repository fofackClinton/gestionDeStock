package com.fintech.gestionDeStock.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper=true)
@Table(name="ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="commande_fournisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name="quantité")
    private BigDecimal quantité;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;

}
