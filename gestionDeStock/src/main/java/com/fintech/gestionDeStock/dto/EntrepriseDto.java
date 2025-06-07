package com.fintech.gestionDeStock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private AdresseDto adresse;

    private String description;

    private String codeFiscale;

    private String email;

    private String photos;

    private String numeroTelephone;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null)
            return null;

        return EntrepriseDto.builder()
                .nom(entreprise.getNom())
                .adresse(AdresseDto.fromoEntity(entreprise.getAdresse()))
                .description(entreprise.getDescription())
                .codeFiscale(entreprise.getCodeFiscale())
                .email(entreprise.getEmail())
                .numeroTelephone(entreprise.getNumeroTelephone())
                .siteWeb(entreprise.getSiteWeb())
                .utilisateurs(entreprise.getUtilisateurs() == null ? entreprise.getUtilisateurs().stream()
                        .map(UtilisateurDto::fromEntity).collect(Collectors.toList()) : null)
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null)
            return null;

        Entreprise entreprise = new Entreprise();
        entreprise.setNom(entrepriseDto.nom);
        entreprise.setAdresse(entrepriseDto.adresse == null ? AdresseDto.toEntity(entrepriseDto.getAdresse()) : null);
        entreprise.setDescription(entrepriseDto.description);
        entreprise.setCodeFiscale(entrepriseDto.codeFiscale);
        entreprise.setEmail(entrepriseDto.email);
        entreprise.setPhotos(entrepriseDto.photos);
        entreprise.setNumeroTelephone(entrepriseDto.numeroTelephone);
        entreprise.setSiteWeb(entrepriseDto.siteWeb);
        entreprise.setUtilisateurs(entreprise.getUtilisateurs() == null
                ? entrepriseDto.utilisateurs.stream().map(UtilisateurDto::toEntity).collect(Collectors.toList())
                : null);
        return entreprise;
    }

}
