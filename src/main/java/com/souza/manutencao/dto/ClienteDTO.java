package com.souza.manutencao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private Long idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDateTime createdAt;
}
