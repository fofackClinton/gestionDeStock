package com.fintech.gestionDeStock.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@Table(name="vente")
public class Vente extends AbstractEntity {

    @Column(name="code")
    private String code;

    @Column(name="date_vente")
    private Instant dateVente;

    @Column(name="commentaire")
    private String commentaire;

}
