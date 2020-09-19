package com.souza.manutencao.controllers;

import com.souza.manutencao.business_exceptions.OrdemStatusException;
import com.souza.manutencao.entity.OrdemServico;
import com.souza.manutencao.entity.enums.OrdemStatus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GerenciardorOrdensControllerTest {

    private GerenciardorOrdensController controller;

    @Before
    public void setup(){
        controller = new GerenciardorOrdensController();
    }

    @Test
    public void iniciar() {
        OrdemServico ordemServico = OrdemServico.builder().ordemStatus(OrdemStatus.CRIADA).build();
        OrdemServico iniciada = controller.iniciar(ordemServico);

        assertEquals(iniciada.getOrdemStatus(), OrdemStatus.EM_EXECUCAO);
    }

    @Test(expected = OrdemStatusException.class)
    public void finalizarOrdemSemStatusExecucao() {
        OrdemServico ordem = OrdemServico.builder().ordemStatus(OrdemStatus.CRIADA).build();
        controller.finalizar(ordem);
    }

    @Test
    public void finalizarOrdem(){
        OrdemServico ordemServico = OrdemServico.builder().ordemStatus(OrdemStatus.EM_EXECUCAO).build();
        OrdemServico finalizada = controller.finalizar(ordemServico);

        assertEquals(finalizada.getOrdemStatus(), OrdemStatus.FINALIZADA);
    }
}