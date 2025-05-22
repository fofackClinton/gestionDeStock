package com.fintech.gestionDeStock.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="entreprise")
public class Entreprise extends AbstractEntity {

    @Column(name="nom")
    private String nom;

    @Embedded
    private Adresse adresse;

    @Column(name="description")
    private String description;

    @Column(name="code_fiscale")
    private String codeFiscale;

    @Column(name="email")
    private String email;

    @Column(name="photo")
    private String photos;

    @Column(name="numero_telephone")
    private String numeroTelephone;

    @Column(name="site_web")
    private String siteWeb;

    @OneToMany(mappedBy="entreprise")
    private List<Utilisateur> utilisateurs;


}
