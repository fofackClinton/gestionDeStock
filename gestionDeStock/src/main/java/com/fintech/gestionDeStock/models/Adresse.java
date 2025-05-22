package com.fintech.gestionDeStock.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Adresse implements Serializable{

    @Column(name="adresse1")
    private String adress1;

    @Column(name="adresse2")
    private String adress2;

    @Column(name="code_postale")
    private String codePostal;

    @Column(name="pays")
    private String pays;

}
