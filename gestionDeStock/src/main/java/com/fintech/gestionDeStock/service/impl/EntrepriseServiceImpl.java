package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.EntrepriseDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Entreprise;
import com.fintech.gestionDeStock.repository.EntrepriseRepository;
import com.fintech.gestionDeStock.service.EntrepriseService;
import com.fintech.gestionDeStock.validator.EntrepriseValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;

    @Override
    public void delete(Integer id) {
        if (id == null) {
            return;
        }
        entrepriseRepository.deleteById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(
                () -> new EntityNotFoundException("l'entreprise " + id + "n'existe pas dans la BDD",
                        ErrorCode.ENTREPRISE_NOT_FUND));
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise is not vald", dto);
            throw new InvalidEntityException("l'entreprise n'est pas valide", errors, ErrorCode.ENTREPRISE_NOT_VALID);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

}
