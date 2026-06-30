package com.example.geobras.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrcamentoRequestDTO(
        @Min(value = 0, message = "Insira uma distância válida")
        @NotNull(message = "Insira o deslocamento")
        Double deslocamento,

        @Min(value = 0, message = "Insira uma mão de obra válida")
        @NotNull(message = "Insira o valor da mão de obra")
        Double maoDeObra,

        @NotBlank(message = "Insira o tipo de serviço")
        String servico,

        @Min(value = 0, message = "Insira um valor válido")
        @NotNull(message = "Insira o valor do aluguel do equipamento")
        Double aluguelDeEquipamento,

        @Min(value = 0, message = "Insira uma soma de materiais maior que 0")
        @NotNull(message = "Insira a soma dos materiais")
        Double somaMateriais,

        @Min(value = 0, message = "Insira um imposto válido")
        @NotNull(message = "Insira a porcentagem do imposto")
        Double imposto
) {
}
