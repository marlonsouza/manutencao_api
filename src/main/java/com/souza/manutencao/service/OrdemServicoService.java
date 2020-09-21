package com.souza.manutencao.service;

import com.souza.manutencao.entity.OrdemServico;
import com.souza.manutencao.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository repository;


    public OrdemServico save(OrdemServico toSave){
        OrdemServico entity = repository.save(toSave);

        return entity;
    }

    public List<OrdemServico> findAll(){
        return repository.findAll();
    }

    public List<OrdemServico> getOrdensPendentes() {
        return repository.findByInicioServicoIsNullOrderByCreatedAtDesc();
    }

    public List<OrdemServico> getOrdensIniciadas(){
        return repository.findByInicioServicoIsNotNullAndFinalServicoIsNullOrderByCreatedAtDesc();
    }

    public OrdemServico findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
