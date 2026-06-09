package com.example.geobras.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrcamentoRequestDTO(
        @NotNull(message = "Insira o deslocamento")
        Double deslocamento,

        @NotBlank(message = "Insira a lisa de materiais")
        List<String> materiais,

        @NotNull(message = "Insira o valor dos materiais")
        List<Double> valorMateriais,

        @NotNull(message = "Insira o valor da mão de obra")
        Integer maoDeObra,

        @NotBlank(message = "Insira o tipo de serviço")
        String servico,

        @NotNull(message = "Insira o valor do aluguel do equipamento")
        Double aluguelDeEquipamento,

        @NotNull(message = "Insira a porcentagem do imposto")
        Double imposto
) {
}
