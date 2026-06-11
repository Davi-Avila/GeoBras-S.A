package com.example.geobras.dto;

public record OrcamentoResponseDTO(
        Double deslocamento,
        Integer maoDeObra,
        String servico,
        Double aluguelDeEquipamento,
        Double imposto,
        Double orcamentoTotal
) {
}
