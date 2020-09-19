package com.souza.manutencao.mappers;

import com.souza.manutencao.dto.ClienteDTO;
import com.souza.manutencao.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "id"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "endereco", target = "endereco"),
            @Mapping(source = "telefone", target = "telefone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    Cliente from(ClienteDTO dto);

   @Mappings({
            @Mapping(source = "id", target = "idCliente"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "endereco", target = "endereco"),
            @Mapping(source = "telefone", target = "telefone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    ClienteDTO to(Cliente cliente);
}
