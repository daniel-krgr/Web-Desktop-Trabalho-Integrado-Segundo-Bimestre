package br.unipar.web_trabalho.respository;

import br.unipar.web_trabalho.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNomeContaining(String nome);

}
