package com.souza.manutencao.endpoints;

import com.souza.manutencao.dto.UserDTO;
import com.souza.manutencao.entity.User;
import com.souza.manutencao.mappers.UserMapper;
import com.souza.manutencao.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@EnableResourceServer
public class UserController {

    private UserService service;

    private UserMapper mapper;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){
        User entity = service.save(mapper.from(user));

        return ResponseEntity.ok(mapper.to(entity));
    }

}
