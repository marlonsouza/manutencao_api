package com.souza.manutencao.mappers;

import com.souza.manutencao.dto.OrdemServicoDTO;
import com.souza.manutencao.entity.OrdemServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrdemServicoMapper {

    @Mappings({
            @Mapping(source = "idOrdem", target = "id"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "idCliente", target = "cliente.id"),
            @Mapping(source = "idEquipamento", target = "equipamento.id"),
            @Mapping(source = "inicioServico", target = "inicioServico", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "finalServico", target = "finalServico", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
    })
    OrdemServico from(OrdemServicoDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "idOrdem"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "cliente.id", target = "idCliente"),
            @Mapping(source = "equipamento.id", target = "idEquipamento"),
            @Mapping(source = "inicioServico", target = "inicioServico", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "finalServico", target = "finalServico", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
    })
    OrdemServicoDTO to(OrdemServico ordemServico);

}
