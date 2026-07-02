package com.example.geobras.dto;

import java.time.LocalDate;

public record ObraResponseDTO(
        Long idObra,

        String nomeObra,

        String endereco,

        LocalDate dataInicio,

        LocalDate dataFimPrevisto,

        String etapa,

        Double orcamentoTotal,

        String nomeCliente,

        String email,

        Long idOrcamento,

        Long idCliente

        ) {
}
