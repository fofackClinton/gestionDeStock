package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {

public CommandeFournisseurDto save(CommandeFournisseurDto dto);

public List<CommandeFournisseurDto> findAll();

public void delete(Integer id);

public CommandeFournisseurDto findById(Integer id);

public CommandeFournisseurDto findByCode(String code);

}
