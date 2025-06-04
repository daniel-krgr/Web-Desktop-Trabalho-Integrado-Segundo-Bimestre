package br.unipar.web_trabalho.service;


import br.unipar.web_trabalho.domain.ItemVenda;
import br.unipar.web_trabalho.respository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public ItemVenda insert(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public List<ItemVenda> findByProdutoId(Long produtoId) {
        if (produtoId != null) {
            return itemVendaRepository.findByProdutoId(produtoId);
        }
        return itemVendaRepository.findAll();
    }

    public List<ItemVenda> findByVendaId(Long vendaId) {
        if (vendaId != null) {
            return itemVendaRepository.findByVendaId(vendaId);
        }
        return itemVendaRepository.findAll();
    }

    public void delete(Long id) {
        itemVendaRepository.deleteById(id);
    }

    public ItemVenda update(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

}
