package com.souza.manutencao.entity.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrdemStatus {

    CRIADA(1),
    EM_EXECUCAO(2),
    FINALIZADA(3),
    CANCELADA(4);

    private final Integer id;

    OrdemStatus(Integer id) {
        this.id = id;
    }

    public static OrdemStatus from(Integer id) {
        OrdemStatus[] values = OrdemStatus.values();
        return Arrays.asList(values).stream().filter(s -> s.getId().equals(id) ).findFirst().get();
    }
}
