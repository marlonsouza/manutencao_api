package com.souza.manutencao.service;

import com.souza.manutencao.entity.Equipamento;
import com.souza.manutencao.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public Equipamento save(Equipamento toSave){
        Equipamento entity = repository.save(toSave);

        return entity;
    }

    public List<Equipamento> findAll(){
        return repository.findAll();
    }

    public Equipamento findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado."));
    }

}
