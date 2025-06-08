package br.unipar.web_trabalho.controller;

import br.unipar.web_trabalho.domain.Produto;
import br.unipar.web_trabalho.dto.ProdutoRequestDTO;
import br.unipar.web_trabalho.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO,
                                          UriComponentsBuilder builder) {
        Produto produto = new Produto(produtoRequestDTO);
        produto = produtoService.insert(produto);

        URI uri = builder.path("/cliente/{id}").
                        buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(
            @RequestParam(value = "descricao", required = false) String descricao) {
        List<Produto> retorno = produtoService.findAll(descricao);

        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id,
                          @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto(id, produtoRequestDTO);

        produto = produtoService.update(produto);

        return ResponseEntity.ok(produto);
    }

}
