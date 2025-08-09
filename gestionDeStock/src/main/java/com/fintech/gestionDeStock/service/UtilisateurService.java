package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.UtilisateurDto;

public interface UtilisateurService {

    public UtilisateurDto save(UtilisateurDto dto);

    public UtilisateurDto findById(Integer id);

    public List<UtilisateurDto> findAll();

    public void delete(Integer id);
}
