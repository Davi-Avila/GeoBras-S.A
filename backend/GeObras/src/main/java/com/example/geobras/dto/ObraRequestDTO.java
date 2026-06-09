package com.example.geobras.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ObraRequestDTO(
        @NotBlank(message = "Insira um nome para a obra")
        String nomeObra,

        @NotBlank(message = "Insira o endereço da obra")
        String endereco,

        @NotNull(message = "Insira uma data de início")
        LocalDate dataInicio,

        @NotNull(message = "Insira uma data prevista")
        LocalDate dataFimPrevisto,

        String etapa,

        @NotNull(message = "Insira um orçamento correspondente")
        Long idOrcamento,

        @NotNull(message = "Insira um cliente")
        Long idCliente


) {
}
