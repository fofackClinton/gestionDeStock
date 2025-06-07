package com.fintech.gestionDeStock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String numTel;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .numTel(client.getNumTel())
                .adresse(client.getAdresse() != null ? AdresseDto.fromoEntity(client.getAdresse()) : null)
                .photo(client.getPhoto())
                .mail(client.getMail())
                .commandeClients(client.getCommandeClients() != null
                        ? client.getCommandeClients().stream().map(CommandeClientDto::fromEntity)
                                .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setNom(clientDto.nom);
        client.setPrenom(clientDto.prenom);
        client.setNumTel(clientDto.numTel);
        client.setAdresse(clientDto.getAdresse() == null ? AdresseDto.toEntity(clientDto.getAdresse()) : null);
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setCommandeClients(clientDto.getCommandeClients() != null
                ? clientDto.getCommandeClients().stream().map(CommandeClientDto::toEntity).collect(Collectors.toList())
                : null);
        return client;
    }

}
