package com.fintech.gestionDeStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.CommandeFournisseurDto;
import com.fintech.gestionDeStock.dto.LigneCommandeFournisseurDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Article;
import com.fintech.gestionDeStock.models.CommandeFournisseur;
import com.fintech.gestionDeStock.models.Fournisseur;
import com.fintech.gestionDeStock.models.LigneCommandeFournisseur;
import com.fintech.gestionDeStock.repository.ArticleRepository;
import com.fintech.gestionDeStock.repository.CommandeFournisseurRepository;
import com.fintech.gestionDeStock.repository.FournisseurRepository;
import com.fintech.gestionDeStock.repository.LigneCommandeFournisseurRepository;
import com.fintech.gestionDeStock.service.CommandeFournisseurService;
import com.fintech.gestionDeStock.validator.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService {
    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurImpl(CommandeFournisseurRepository commandeFournisseurRepository,
    LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,FournisseurRepository fournisseurRepository,
    ArticleRepository articleRepository)
    {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.articleRepository = articleRepository;
        this.commandeFournisseurRepository = commandeFournisseurRepository;
    }


    @Override
    public void delete(Integer id) {
       if(id == null){
        return;
       }
        commandeFournisseurRepository.deleteById(id);
        
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {

        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(CommandeFournisseurDto::fromEntity)
        .orElseThrow(()-> new EntityNotFoundException("Aucune commande Fournisseur trouvé avec le code"+code,ErrorCode.COMMANDE_FOURNISSEUR_NOT_FUND));
    } 

    @Override
    public CommandeFournisseurDto findById(Integer id) {
       return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity)
       .orElseThrow(()-> new EntityNotFoundException("la commande client avec l'id n'existe pas", ErrorCode.COMMANDE_FOURNISSEUR_NOT_FUND));
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if(errors.isEmpty()){
            log.error("commande fournisseur invalide");
            throw new InvalidEntityException("commande client invalide",ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID );
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if(fournisseur.isEmpty()){
            log.error("le fourniisseur avec l'id"+dto.getFournisseur().getId()+"n'existe pas dans la bdd");
            throw new EntityNotFoundException("le fourniisseur avec l'id"+dto.getFournisseur().getId()+"n'existe pas dans la bdd",ErrorCode.COMMANDE_FOURNISSEUR_NOT_FUND);
        }

        List<String> errorsArticle = new ArrayList<>();
        if(dto.getLigneCommandeFournisseurs() != null){
            dto.getLigneCommandeFournisseurs().forEach(lcmFr ->{
                Optional<Article> article = articleRepository.findById(lcmFr.getArticle().getId());
                if(article.isEmpty()){
                    errorsArticle.add("L'article avec l'id"+lcmFr.getArticle().getId()+"n'existe pas");
                }
            });
        }else{
            errorsArticle.add("impossible d'enregistré une commande avec un article vide");
        }

        if(!errorsArticle.isEmpty()){
            log.warn("impossible d'enregistré une commande avec des articles vides");
            throw new InvalidEntityException("impossible d'nregistré une commande avce des articles vides",errorsArticle,ErrorCode.ARTICLE_NOT_FUND);
        }

        CommandeFournisseur cmdf = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if(dto.getLigneCommandeFournisseurs() != null){
            dto.getLigneCommandeFournisseurs().forEach(lcmF ->{
                LigneCommandeFournisseur ligneOptional = LigneCommandeFournisseurDto.toEntity(lcmF);
                ligneOptional.setCommandeFournisseur(cmdf);
                ligneCommandeFournisseurRepository.save(ligneOptional);
            });
        }


        return CommandeFournisseurDto.fromEntity(cmdf);
    }

}
