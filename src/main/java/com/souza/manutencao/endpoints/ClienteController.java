package com.souza.manutencao.endpoints;

import com.souza.manutencao.dto.ClienteDTO;
import com.souza.manutencao.entity.Cliente;
import com.souza.manutencao.mappers.ClienteMapper;
import com.souza.manutencao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = service.save(mapper.from(clienteDTO));

        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<ClienteDTO> clientes = service.findAll().stream().map(mapper::to).collect(Collectors.toList());

        return ResponseEntity.ok(clientes);
    }
}
