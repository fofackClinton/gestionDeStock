package com.fintech.gestionDeStock.service;

import java.util.List;
import com.fintech.gestionDeStock.dto.FournisseurDto;

public interface FournisseurService {

    public FournisseurDto save(FournisseurDto dto);

    public FournisseurDto findById(Integer id);

    public List<FournisseurDto> findAll();

    public void delete(Integer id);
}
