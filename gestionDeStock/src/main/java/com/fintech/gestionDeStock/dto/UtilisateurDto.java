package com.fintech.gestionDeStock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Instant dateNaissance;

    private String email;

    private String password;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;

        return UtilisateurDto.builder()
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .dateNaissance(utilisateur.getDateNaissance())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .adresse(AdresseDto.fromoEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(utilisateur.getRoles() == null
                        ? utilisateur.getRoles().stream().map(RolesDto::fromEntity).collect(Collectors.toList())
                        : null)
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null)
            return null;

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurDto.nom);
        utilisateur.setPrenom(utilisateurDto.prenom);
        utilisateur.setDateNaissance(utilisateurDto.dateNaissance);
        utilisateur.setEmail(utilisateurDto.email);
        utilisateur.setPrenom(utilisateurDto.password);
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.adresse));
        utilisateur.setPhoto(utilisateurDto.photo);
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.entreprise));
        utilisateur.setRoles(utilisateurDto.roles == null
                ? utilisateurDto.roles.stream().map(RolesDto::toEntity).collect(Collectors.toList())
                : null);
        return utilisateur;
    }

}
