package br.unipar.web_trabalho.respository;

import br.unipar.web_trabalho.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByDescricaoContaining(String descricao);

}
