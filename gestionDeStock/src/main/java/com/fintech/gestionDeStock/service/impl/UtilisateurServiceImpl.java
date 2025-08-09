package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.UtilisateurDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Utilisateur;
import com.fintech.gestionDeStock.repository.UtilisateurRepository;
import com.fintech.gestionDeStock.service.UtilisateurService;
import com.fintech.gestionDeStock.validator.UtilisateurValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
        utilisateurRepository.deleteById(id);  
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
           return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(
            ()-> new EntityNotFoundException("l'utilisateur "+id+ "n'existe pas dans la BDD", ErrorCode.UTILISATEUR_NOT_FUND ));
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
       List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid", dto);
            throw new InvalidEntityException("l'utilisateur n'est pas valide", errors, ErrorCode.UTILISATEUR_NOT_VALID);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }
}
