package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.EntrepriseDto;

public interface EntrepriseService {

    public EntrepriseDto save(EntrepriseDto dto);

    public EntrepriseDto findById(Integer id);

    public List<EntrepriseDto> findAll();

    public void delete(Integer id);
}
