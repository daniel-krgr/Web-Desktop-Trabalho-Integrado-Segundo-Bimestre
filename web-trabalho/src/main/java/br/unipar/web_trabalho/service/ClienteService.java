package br.unipar.web_trabalho.service;

import br.unipar.web_trabalho.domain.Cliente;
import br.unipar.web_trabalho.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return clienteRepository.findByNomeContaining(nome);
        }
        return clienteRepository.findAll();
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
