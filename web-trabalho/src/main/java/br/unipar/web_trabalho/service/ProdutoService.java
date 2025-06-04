package br.unipar.web_trabalho.service;

import br.unipar.web_trabalho.domain.Produto;
import br.unipar.web_trabalho.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            return produtoRepository.findByDescricaoContaining(descricao);
        }
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }
}
