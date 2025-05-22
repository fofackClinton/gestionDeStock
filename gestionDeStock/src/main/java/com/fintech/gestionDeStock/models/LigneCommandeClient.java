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
@Builder
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="ligne_commande_client")
public class LigneCommandeClient extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_commande_client")
    private  CommandeClient commandeClient;

    @Column(name="quantité")
    private BigDecimal quantité;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;

}
