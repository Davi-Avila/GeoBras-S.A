package com.example.geobras.dto;

public record OrcamentoResponseDTO(
        Long idOrcamento,
        Double deslocamento,
        Double maoDeObra,
        String servico,
        Double aluguelDeEquipamento,
        Double imposto,
        Double orcamentoTotal
) {
}
