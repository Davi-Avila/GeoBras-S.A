package com.example.geobras.dto;

public record ClienteResponseDTO(
        String nomeCliente,
        String email,
        String pais,
        String CEP,
        String CPF,
        String CNPJ
) {
}
