package br.unipar.web_trabalho.controller;

import br.unipar.web_trabalho.domain.Venda;
import br.unipar.web_trabalho.dto.VendaRequestDTO;
import br.unipar.web_trabalho.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody @Valid VendaRequestDTO vendaRequestDTO,
                                        UriComponentsBuilder builder) {
        Venda venda = new Venda(vendaRequestDTO);
        venda = vendaService.insert(venda);

        URI uri = builder.path("/vendas/{id}")
                .buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(
            @RequestParam(value = "clienteId", required = false) Long clienteId){
        List<Venda> retorno = vendaService.findByCliente(clienteId);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id,
                                        @RequestBody @Valid VendaRequestDTO vendaRequestDTO) {
        Venda venda = new Venda(id, vendaRequestDTO);
        venda = vendaService.update(venda);
        return ResponseEntity.ok(venda);
    }



}
