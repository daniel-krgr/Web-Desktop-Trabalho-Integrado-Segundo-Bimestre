package br.unipar.web_trabalho.respository;

import br.unipar.web_trabalho.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    public List<Venda> findByClienteId(Long clienteId);

}
