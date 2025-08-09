package com.fintech.gestionDeStock.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fintech.gestionDeStock.dto.ClientDto;
import com.fintech.gestionDeStock.exception.EntityNotFoundException;
import com.fintech.gestionDeStock.exception.ErrorCode;
import com.fintech.gestionDeStock.exception.InvalidEntityException;
import com.fintech.gestionDeStock.models.Client;
import com.fintech.gestionDeStock.repository.ClientRepository;
import com.fintech.gestionDeStock.service.ClientService;
import com.fintech.gestionDeStock.validator.ClientValidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
        clientRepository.deleteById(id); 
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            return null;
        }

        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(
            ()->new EntityNotFoundException("Le client"+id+"n'existe pas dans la BDD", ErrorCode.COMMANDE_CLIENT_NOT_FUND));
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Client is not valid", dto);
            throw new InvalidEntityException("Le client n'est as valid", errors, ErrorCode.CLIENT_NOT_VALID);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

}
