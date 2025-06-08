/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author mateu
 */
public class VendaRequestDTO {
   
    private Long idCliente;
    private List<ItemVendaRequestDTO> itens;
    private String observacao;

    public VendaRequestDTO() {
    }

    public VendaRequestDTO(Long idCliente, List<ItemVendaRequestDTO> itens, String observacao) {
        this.idCliente = idCliente;
        this.itens = itens;
        this.observacao = observacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemVendaRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaRequestDTO> itens) {
        this.itens = itens;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
