package com.fintech.gestionDeStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fintech.gestionDeStock.dto.CommandeClientDto;
import com.fintech.gestionDeStock.dto.LigneCommandeClientDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Article;
import com.fintech.gestionDeStock.models.Client;
import com.fintech.gestionDeStock.models.CommandeClient;
import com.fintech.gestionDeStock.models.LigneCommandeClient;
import com.fintech.gestionDeStock.repository.ArticleRepository;
import com.fintech.gestionDeStock.repository.ClientRepository;
import com.fintech.gestionDeStock.repository.CommandeClientRepository;
import com.fintech.gestionDeStock.repository.LigneCommandeClientRepository;
import com.fintech.gestionDeStock.service.CommandeClientService;
import com.fintech.gestionDeStock.validator.CommandeClientValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CommandeClientImpl implements CommandeClientService {

    private final CommandeClientRepository commandeClientRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeClientRepository ligneCommandeClientRepository;
    private final ArticleRepository articleRepository;
    
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("la commande client n'est pas valide", dto);
            throw new InvalidEntityException("la commande Client n'est pas valid", errors, ErrorCode.COMMANDE_CLIENT_NOT_Valid);
        } 

        Optional<Client> clientOptiional =  clientRepository.findById(dto.getClient().getId());

        if(clientOptiional.isEmpty()){
            log.error("le client avec l'id"+dto.getClient().getId()+"n'a pas été trouvé");
            throw new EntityNotFoundException("le client avec l'ID"+dto.getClient().getId()+"n'est pas present dans la bdd");
        }

        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(lcdcl -> {
                if(lcdcl.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(lcdcl.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("L'article avec l'ID"+lcdcl.getArticle().getId()+"n'existe pas");
                    }
                }
            });
        }else{
            articleErrors.add("impossible d'ajouter une commande avec un article null");
        }

        if(!articleErrors.isEmpty()){
            log.error("");
            throw new InvalidEntityException("l'article n'existe pas dans la BDD",articleErrors,ErrorCode.ARTICLE_NOT_FUND);
        }

        CommandeClient cmdclSave = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if(dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(lccl->{
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(lccl);
                ligneCommandeClient.setCommandeClient(cmdclSave);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(cmdclSave);

    }

    @Override
    public List<CommandeClientDto> findAll() {
        
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            return null;
        }

         Optional<CommandeClient> commandeClient = commandeClientRepository.findById(id);

         return Optional.of(CommandeClientDto.fromEntity(commandeClient.get())).orElseThrow(
            ()-> new EntityNotFoundException("la commande client"+id+"n'exista pas dans la BDD",ErrorCode.COMMANDE_CLIENT_NOT_FUND)
         );
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }

        commandeClientRepository.deleteById(id);
       
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
           return null; 
        }
        return commandeClientRepository.findCommandeClientByCode(code).map(CommandeClientDto::fromEntity)
        .orElseThrow(()-> new EntityNotFoundException("Aucune commande client trouvé avec le code"+code, ErrorCode.COMMANDE_CLIENT_NOT_FUND));
    }

}
