package com.souza.manutencao.service;

import com.souza.manutencao.entity.Cliente;
import com.souza.manutencao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClienteService{

    @Autowired
    private ClienteRepository repository;

    public Cliente save(Cliente cliente){

        Cliente entity = repository.save(cliente);

        return entity;
    }


    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
    }
}
