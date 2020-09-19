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
public class EquipamentoDTO {

    private Long idEquipamento;
    private String tipo;
    private String marca;
    private LocalDateTime createdAt;
}
