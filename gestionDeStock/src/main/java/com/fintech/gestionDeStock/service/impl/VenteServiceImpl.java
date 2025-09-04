package com.fintech.gestionDeStock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.LigneVenteDto;
import com.fintech.gestionDeStock.dto.VenteDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Article;
import com.fintech.gestionDeStock.models.LigneVente;
import com.fintech.gestionDeStock.models.Ventes;
import com.fintech.gestionDeStock.repository.ArticleRepository;
import com.fintech.gestionDeStock.repository.LigneVenteRepository;
import com.fintech.gestionDeStock.repository.VenteRepository;
import com.fintech.gestionDeStock.service.VenteService;
import com.fintech.gestionDeStock.validator.VenteValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

    private static VenteRepository venteRepository;
    private static ArticleRepository articleRepository;
    private static LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(VenteRepository venteRepository, ArticleRepository articleRepository,LigneVenteRepository ligneVenteRepository){
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("la vente est invalide");
            throw new InvalidEntityException("Impossible d'enregistré une vente invalide",errors, ErrorCode.VENTE_NOT_VALID);
        }

        List<String> errorsArticle = new ArrayList<>();
        dto.getLigneVentes().forEach(lignvVenteDto->{
            Optional<Article> article = articleRepository.findById(lignvVenteDto.getArticle().getId());
            if(article.isEmpty()){
                errorsArticle.add("Aucun article avec l'ID"+lignvVenteDto.getArticle().getId()+"n'a été trouvé dans la BDD");
            }
        });

        if(!errorsArticle.isEmpty()){
             log.error("la vente est invalide");
            throw new InvalidEntityException("Impossible d'enregistré une vente invalide",errorsArticle, ErrorCode.VENTE_NOT_VALID);
        }

        Ventes vente = venteRepository.save(VenteDto.toEntity(dto));
        
        dto.getLigneVentes().forEach(ligneVenteDto->{
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(vente);
            ligneVenteRepository.save(ligneVente);
        });

        return VenteDto.fromEntity(vente);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream().map(VenteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
        venteRepository.deleteById(id);
    }

    @Override
    public VenteDto findById(Integer id) {
        if(id == null){
            return null;
        }
        Optional<Ventes> venteOptional = venteRepository.findById(id);
        return Optional.of(VenteDto.fromEntity(venteOptional.get())).orElseThrow(
            ()-> new EntityNotFoundException("la vente avec l'id n'a pas été trouvé",ErrorCode.VENTE_NOT_FUND)
        );
    }

    @Override
    public VenteDto findByCode(String code) {
        return venteRepository.findVenteByCode(code).map(VenteDto::fromEntity).orElseThrow(
            ()-> new EntityNotFoundException("la commande avec le code"+code+" n'existe pas",ErrorCode.VENTE_NOT_FUND)
        );
    }

}
