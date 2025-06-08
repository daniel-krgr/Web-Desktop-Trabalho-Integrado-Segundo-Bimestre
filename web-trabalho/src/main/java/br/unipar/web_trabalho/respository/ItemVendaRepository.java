package br.unipar.web_trabalho.respository;

import br.unipar.web_trabalho.domain.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    public List<ItemVenda> findByVendaId(Long vendaId);
    public List<ItemVenda> findByProdutoId(Long produtoId);

}
