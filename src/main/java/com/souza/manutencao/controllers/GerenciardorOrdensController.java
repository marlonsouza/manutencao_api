package com.souza.manutencao.controllers;

import com.souza.manutencao.business_exceptions.OrdemStatusException;
import com.souza.manutencao.entity.OrdemServico;
import com.souza.manutencao.entity.enums.OrdemStatus;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class GerenciardorOrdensController {

    public OrdemServico iniciar(OrdemServico ordem){
        if(ordem.getOrdemStatus() != OrdemStatus.CRIADA){
            throw new OrdemStatusException("Ordem de serviço não está com status criado.");
        }

        ordem.setOrdemStatus(OrdemStatus.EM_EXECUCAO);
        ordem.setInicioServico(LocalDateTime.now());

        return ordem;
    }

    public OrdemServico finalizar(OrdemServico ordem) throws OrdemStatusException {

        if(ordem.getOrdemStatus() != OrdemStatus.EM_EXECUCAO){
            throw new OrdemStatusException("Ordem de serviço não está em execução.");
        }

        ordem.setOrdemStatus(OrdemStatus.FINALIZADA);
        ordem.setFinalServico(LocalDateTime.now());

        return ordem;
    }

}
