package com.souza.manutencao.endpoints;

import com.souza.manutencao.business_exceptions.OrdemStatusException;
import com.souza.manutencao.controllers.GerenciardorOrdensController;
import com.souza.manutencao.dto.OrdemServicoDTO;
import com.souza.manutencao.entity.Cliente;
import com.souza.manutencao.entity.Equipamento;
import com.souza.manutencao.entity.OrdemServico;
import com.souza.manutencao.mappers.OrdemServicoMapper;
import com.souza.manutencao.service.ClienteService;
import com.souza.manutencao.service.EquipamentoService;
import com.souza.manutencao.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService service;

    @Autowired
    private OrdemServicoMapper mapper;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private GerenciardorOrdensController gerenciadorOrdens;

    @PostMapping("/ordem")
    public ResponseEntity<OrdemServicoDTO> save(@RequestBody OrdemServicoDTO ordem){

        Cliente cliente = clienteService.findById(ordem.getIdCliente());

        Equipamento equipamento = equipamentoService.findById(ordem.getIdEquipamento());

        OrdemServico entity = service.save(mapper.from(ordem));

        return ResponseEntity.ok(mapper.to(entity));
    }

    @GetMapping("/ordem/pendente")
    public  ResponseEntity<List<OrdemServicoDTO>> getOrdensPendentes(){
        List<OrdemServicoDTO> ordensPendentes = service.getOrdensPendentes().stream().map(mapper::to).collect(Collectors.toList());

        return ResponseEntity.ok(ordensPendentes);
    }

    @GetMapping("/ordem/iniciada")
    public ResponseEntity<List<OrdemServicoDTO>> getOrdensIniciadas(){
        List<OrdemServicoDTO> ordensIniciadas = service.getOrdensIniciadas().stream().map(mapper::to).collect(Collectors.toList());
        return  ResponseEntity.ok(ordensIniciadas);
    }


    @PutMapping("/ordem/{id}/iniciar")
    public ResponseEntity iniciar(@PathVariable Long id){
        OrdemServico ordem = service.findById(id);

        OrdemServico ordemIniciada = gerenciadorOrdens.iniciar(ordem);

        service.save(ordemIniciada);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/ordem/{id}/finalizar")
    public ResponseEntity finalizar(@PathVariable Long id) throws OrdemStatusException {
        OrdemServico ordem = service.findById(id);

        OrdemServico finalizada = gerenciadorOrdens.finalizar(ordem);

        service.save(finalizada);

        return ResponseEntity.ok().build();
    }

}
