package com.souza.manutencao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoDTO {

    private Long idOrdem;
    private Long idCliente;
    private Long idEquipamento;
    private String descricao;
    private LocalDateTime inicioServico;
    private LocalDateTime finalServico;
    private LocalDateTime createdAt;

}
