package com.fintech.gestionDeStock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.Fournisseur;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String numTel;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private List<CommandeFournisseurDto> commandeFournisseurs;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null)
            return null;

        return FournisseurDto.builder()
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .numTel(fournisseur.getNumTel())
                .adresse(fournisseur.getAdresse() == null ? AdresseDto.fromoEntity(fournisseur.getAdresse()) : null)
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .commandeFournisseurs(
                        fournisseur.getCommandeFournisseurs() == null ? fournisseur.getCommandeFournisseurs().stream()
                                .map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList()) : null)
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null)
            return null;

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom(fournisseurDto.nom);
        fournisseur.setPrenom(fournisseurDto.prenom);
        fournisseur.setNumTel(fournisseurDto.numTel);
        fournisseur
                .setAdresse(fournisseurDto.adresse == null ? AdresseDto.toEntity(fournisseurDto.getAdresse()) : null);
        fournisseur.setPhoto(fournisseurDto.photo);
        fournisseur.setMail(fournisseurDto.mail);
        fournisseur.setCommandeFournisseurs(
                fournisseurDto.getCommandeFournisseurs() == null ? fournisseurDto.getCommandeFournisseurs().stream()
                        .map(CommandeFournisseurDto::toEntity).collect(Collectors.toList()) : null);
        return fournisseur;
    }

}
