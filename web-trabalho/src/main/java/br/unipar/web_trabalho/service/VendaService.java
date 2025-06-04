package br.unipar.web_trabalho.service;


import br.unipar.web_trabalho.domain.Venda;
import br.unipar.web_trabalho.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda insert(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> findByCliente(Long clienteId) {
        if (clienteId != null) {
            return vendaRepository.findByClienteId(clienteId);
        }
        return vendaRepository.findAll();
    }

    public void delete(Long id) {
        vendaRepository.deleteById(id);
    }

    public Venda update(Venda venda) {
        return vendaRepository.save(venda);
    }
}
