package br.unipar.web_trabalho.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaRequestDTO {

    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private int quantidade;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor unitário deve ser maior que zero")
    private Double valorUnitario;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor total deve ser maior que zero")
    private Double valorTotal;

    @NotNull(message = "O ID do produto não pode ser nulo")
    private Long produtoId;

    @NotNull(message = "O ID da venda não pode ser nulo")
    private Long vendaId;



}
