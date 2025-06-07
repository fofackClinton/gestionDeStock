package com.fintech.gestionDeStock.dto;

import com.fintech.gestionDeStock.models.Adresse;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AdresseDto {

    private Integer id;

    private String adress1;

    private String adress2;

    private String codePostal;

    private String pays;

    public static AdresseDto fromoEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }

        return AdresseDto.builder()
                .adress1(adresse.getAdress1())
                .adress2(adresse.getAdress2())
                .codePostal(adresse.getCodePostal())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdress1(adresseDto.adress1);
        adresse.setAdress2(adresseDto.adress2);
        adresse.setCodePostal(adresseDto.codePostal);
        adresse.setPays(adresseDto.pays);
        return adresse;
    }

}
