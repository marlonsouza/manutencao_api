package com.souza.manutencao.mappers;

import com.souza.manutencao.dto.EquipamentoDTO;
import com.souza.manutencao.entity.Equipamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    @Mappings({
            @Mapping(source = "idEquipamento", target = "id"),
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "marca", target = "marca"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    Equipamento from(EquipamentoDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "idEquipamento"),
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "marca", target = "marca"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    EquipamentoDTO to(Equipamento equipamento);
}
