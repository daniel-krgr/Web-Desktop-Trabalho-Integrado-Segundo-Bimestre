package br.unipar.web_trabalho.domain;


import br.unipar.web_trabalho.dto.VendaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "VENDA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    public Venda(VendaRequestDTO vendaRequestDTO) {
        this.observaccoes = vendaRequestDTO.getObservacoes();
        this.valorTotal = vendaRequestDTO.getValorTotal();
        Cliente cliente = new Cliente();
        cliente.setId(vendaRequestDTO.getClienteId());
        this.cliente = cliente;

    }

    public Venda(Long id, VendaRequestDTO vendaRequestDTO) {
        this.id = id;
        this.observaccoes = vendaRequestDTO.getObservacoes();
        this.valorTotal = vendaRequestDTO.getValorTotal();
        Cliente cliente = new Cliente();
        cliente.setId(vendaRequestDTO.getClienteId());
        this.cliente = cliente;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String observaccoes;

    @Column(nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data;

    @Column(nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;
}
