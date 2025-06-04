package br.unipar.web_trabalho.controller;


import br.unipar.web_trabalho.domain.Cliente;
import br.unipar.web_trabalho.dto.ClienteRequestDTO;
import br.unipar.web_trabalho.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO,
                                          UriComponentsBuilder builder) {
        Cliente cliente = new Cliente(clienteRequestDTO);
        cliente = clienteService.insert(cliente);

        URI uri = builder.path("/clientes/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(
            @RequestParam(value = "nome", required = false) String nome) {
        List<Cliente> retorno = clienteService.findAll(nome);
        return ResponseEntity.ok(retorno);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id,
                                          @RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente(id, clienteRequestDTO);
        cliente = clienteService.update(cliente);
        return ResponseEntity.ok(cliente);
    }






}
