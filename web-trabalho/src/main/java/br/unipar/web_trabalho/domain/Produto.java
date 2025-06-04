package br.unipar.web_trabalho.domain;

import br.unipar.web_trabalho.dto.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    public Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.descricao = produtoRequestDTO.getDescricao();
        this.valor = produtoRequestDTO.getValor();
        this.categoria = produtoRequestDTO.getCategoria();
    }

    public Produto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        this.id = id;
        this.descricao = produtoRequestDTO.getDescricao();
        this.valor = produtoRequestDTO.getValor();
        this.categoria = produtoRequestDTO.getCategoria();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String categoria;

}
