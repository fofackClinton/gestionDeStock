package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.CommandeClientDto;

public interface CommandeClientService {

    public CommandeClientDto save(CommandeClientDto dto);

    public List<CommandeClientDto> findAll();

    public CommandeClientDto findByCode(String code);

    public CommandeClientDto findById(Integer id);

    public void delete(Integer id);

}
