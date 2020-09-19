package com.souza.manutencao.endpoints;

import com.souza.manutencao.dto.EquipamentoDTO;
import com.souza.manutencao.entity.Equipamento;
import com.souza.manutencao.mappers.EquipamentoMapper;
import com.souza.manutencao.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @Autowired
    private EquipamentoMapper mapper;

    @PostMapping("/equipamento")
    public ResponseEntity<EquipamentoDTO> save(@RequestBody EquipamentoDTO equipamento){
        Equipamento entity = service.save(mapper.from(equipamento));

        return ResponseEntity.ok(mapper.to(entity));
    }

    @GetMapping("/equipamento")
    public ResponseEntity<List<EquipamentoDTO>> findAll(){
        List<EquipamentoDTO> equipamentos = service.findAll().stream().map(mapper::to).collect(Collectors.toList());

        return ResponseEntity.ok(equipamentos);
    }

}
