package br.unipar.web_trabalho.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 60)
    private String descricao;

    @NotNull
    @PositiveOrZero
    private Double valor;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 60)
    private String categoria;

}
