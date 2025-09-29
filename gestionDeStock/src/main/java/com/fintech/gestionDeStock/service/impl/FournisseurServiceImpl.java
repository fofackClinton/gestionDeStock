package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.FournisseurDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Fournisseur;
import com.fintech.gestionDeStock.repository.FournisseurRepository;
import com.fintech.gestionDeStock.service.FournisseurService;
import com.fintech.gestionDeStock.validator.FournisseurValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    @Override
    public void delete(Integer id) {
        if (id == null) {
            return;
        }
        fournisseurRepository.deleteById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(
                () -> new EntityNotFoundException("le fournisseur " + id + "n'existe pas dans la BDD",
                        ErrorCode.FOURNISSEUR_NOT_FUND));
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Fournissuer is not valid", dto);
            throw new InvalidEntityException("le fournisseur n'est pas valide", errors,
                    ErrorCode.FOURNISSEUR_NOT_VALID);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(dto)));
    }

}
