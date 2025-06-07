package com.fintech.gestionDeStock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fintech.gestionDeStock.models.CommandeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {

        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .ligneCommandeClients(
                        commandeClient.getLigneCommandeClients() != null ? commandeClient.getLigneCommandeClients()
                                .stream().map(LigneCommandeClientDto::fromEntity).collect(Collectors.toList()) : null)
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setCode(commandeClientDto.code);
        commandeClient.setDateCommande(commandeClientDto.dateCommande);
        commandeClient
                .setClient(commandeClientDto.client != null ? ClientDto.toEntity(commandeClientDto.getClient()) : null);
        commandeClient.setLigneCommandeClients(
                commandeClientDto.ligneCommandeClients != null ? commandeClientDto.ligneCommandeClients
                        .stream().map(LigneCommandeClientDto::toEntity).collect(Collectors.toList()) : null);
        return commandeClient;

    }

}
