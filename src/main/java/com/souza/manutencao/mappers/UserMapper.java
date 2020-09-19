package com.souza.manutencao.mappers;

import com.souza.manutencao.dto.UserDTO;
import com.souza.manutencao.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    User from(UserDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "email", target = "email")
    })
    UserDTO to(User entity);
}
