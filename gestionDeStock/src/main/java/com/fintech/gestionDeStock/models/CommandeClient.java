package com.fintech.gestionDeStock.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name="commande_client")
public class CommandeClient extends AbstractEntity {
    
    @Column(name="code")
    private String code;

    @Column(name="date_commande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client;

    @OneToMany(mappedBy="commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
    
}
