package com.example.geobras.dto;

public record   OrcamentoResponseDTO(
        Long idOrcamento,
        String nomeOrcamento,
        Double deslocamento,
        Double maoDeObra,
        String servico,
        Double aluguelDeEquipamento,
        Double somaMateriais,
        Double imposto,
        Double orcamentoTotal
) {
}
