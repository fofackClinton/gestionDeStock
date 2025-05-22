package com.fintech.gestionDeStock.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Setter
@Builder
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name="utilisateur")
public class Utilisateur extends AbstractEntity {

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;
    
    @Column(name="date_naissance")
    private Instant dateNaissance;
    
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Embedded
    private Adresse adresse;

    @Column(name="photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name="id_entreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy="utilisateur")
    private List<Roles> roles;

}
