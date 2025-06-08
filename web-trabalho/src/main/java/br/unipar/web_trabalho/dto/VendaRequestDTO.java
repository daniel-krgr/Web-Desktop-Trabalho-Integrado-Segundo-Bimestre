package br.unipar.web_trabalho.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaRequestDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 500, message = "As observações devem ter entre 3 e 500 caracteres")
    private String observacoes;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor total deve ser maior que zero")
    private Double valorTotal;

    @NotNull(message = "O ID do cliente não pode ser nulo")
    private Long clienteId;

}
