package br.unipar.web_trabalho.domain;

import br.unipar.web_trabalho.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    public Cliente (ClienteRequestDTO clienteRequestDTO) {
        this.nome = clienteRequestDTO.getNome();
        this.telefone = clienteRequestDTO.getTelefone();
        this.email = clienteRequestDTO.getEmail();
    }

    public Cliente(Long id, ClienteRequestDTO clienteRequestDTO) {
        this.id = id;
        this.nome = clienteRequestDTO.getNome();
        this.telefone = clienteRequestDTO.getTelefone();
        this.email = clienteRequestDTO.getEmail();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Venda> vendas;


}
