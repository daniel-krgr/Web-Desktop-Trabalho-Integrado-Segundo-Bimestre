package br.unipar.web_trabalho.domain;


import br.unipar.web_trabalho.dto.ItemVendaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEM_VENDA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVenda {

    public ItemVenda(ItemVendaRequestDTO itemVendaRequestDTO) {
        this.quantidade = itemVendaRequestDTO.getQuantidade();
        this.valorUnitario = itemVendaRequestDTO.getValorUnitario();
        this.valorTotal = itemVendaRequestDTO.getValorTotal();
        Produto produto = new Produto();
        produto.setId(itemVendaRequestDTO.getProdutoId());
        this.produto = produto;

        Venda venda = new Venda();
        venda.setId(itemVendaRequestDTO.getVendaId());
        this.venda = venda;
    }

    public ItemVenda(Long id, ItemVendaRequestDTO itemVendaRequestDTO) {
        this.id = id;
        this.quantidade = itemVendaRequestDTO.getQuantidade();
        this.valorUnitario = itemVendaRequestDTO.getValorUnitario();
        this.valorTotal = itemVendaRequestDTO.getValorTotal();
        Produto produto = new Produto();
        produto.setId(itemVendaRequestDTO.getProdutoId());
        this.produto = produto;

        Venda venda = new Venda();
        venda.setId(itemVendaRequestDTO.getVendaId());
        this.venda = venda;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double valorUnitario;

    @Column(nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

}
