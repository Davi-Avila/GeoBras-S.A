package com.example.geobras.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MaterialRequestDTO(
        @NotBlank(message = "Insira o nome do Material")
        String nomeMaterial,

        @Min(value = 0, message = "Insira um valor válido")
        @NotNull(message = "Insira o valor de cada unidade")
        Double valorMaterial,

        @Min(value = 0, message = "Insira uma quantidade válida")
        @NotNull(message = "Insira a quantidade")
        Integer quantidade,

        @NotNull(message = "Insira o id do orçamento")
        Long idOrcamento

) {
}
