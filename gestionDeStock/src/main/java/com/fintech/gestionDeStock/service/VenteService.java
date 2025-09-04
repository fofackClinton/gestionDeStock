package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.VenteDto;

public interface VenteService {

    public VenteDto save( VenteDto dto);

    public List<VenteDto> findAll();

    public void delete(Integer id);

    public VenteDto findById(Integer id);

    public VenteDto findByCode(String code);

}
