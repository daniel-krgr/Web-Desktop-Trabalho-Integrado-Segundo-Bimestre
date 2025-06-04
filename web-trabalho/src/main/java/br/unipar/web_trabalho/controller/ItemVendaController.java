package br.unipar.web_trabalho.controller;


import br.unipar.web_trabalho.domain.ItemVenda;
import br.unipar.web_trabalho.dto.ItemVendaRequestDTO;
import br.unipar.web_trabalho.service.ItemVendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping
    public ResponseEntity<ItemVenda> insert(@RequestBody @Valid ItemVendaRequestDTO itemVendaRequestDTO,
                                          UriComponentsBuilder builder) {
        ItemVenda itemVenda = new ItemVenda(itemVendaRequestDTO);
        itemVenda = itemVendaService.insert(itemVenda);

        URI uri = builder.path("/itens-venda/{id}")
                .buildAndExpand(itemVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(itemVenda);
    }

    @GetMapping(params = "vendaId")
    public ResponseEntity<List<ItemVenda>> findByVenda(
            @RequestParam(value = "vendaId", required = false) Long vendaId) {
        List<ItemVenda> retorno = itemVendaService.findByVendaId(vendaId);

        return ResponseEntity.ok(retorno);
    }

    @GetMapping(params = "produtoId")
    public ResponseEntity<List<ItemVenda>> findByProduto(
            @RequestParam(value = "produtoId", required = false) Long produtoId) {
        List<ItemVenda> retorno = itemVendaService.findByProdutoId(produtoId);

        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemVendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemVenda> update(@PathVariable Long id,
                                            @RequestBody @Valid ItemVendaRequestDTO itemVendaRequestDTO) {
        ItemVenda itemVenda = new ItemVenda(id, itemVendaRequestDTO);
        itemVenda = itemVendaService.update(itemVenda);
        return ResponseEntity.ok(itemVenda);
    }


}
