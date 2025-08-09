package com.fintech.gestionDeStock.service;

import java.util.List;

import com.fintech.gestionDeStock.dto.ClientDto;

public interface ClientService {

    public ClientDto save(ClientDto dto);

    public ClientDto findById(Integer id);

    public List<ClientDto> findAll();

    public void delete(Integer id);
}
