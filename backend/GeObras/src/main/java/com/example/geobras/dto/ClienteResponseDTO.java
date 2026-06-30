package com.example.geobras.dto;

public record ClienteResponseDTO(
        Long idCliente,
        String nomeCliente,
        String email,
        String pais,
        String CEP,
        String CPF,
        String CNPJ
) {
}
