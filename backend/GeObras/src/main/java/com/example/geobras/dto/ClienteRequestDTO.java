package com.example.geobras.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(

        @NotBlank(message = "Insira o nome do cliente")
        String nomeCliente,

        @NotBlank(message = "Insira o email do cliente")
        String email,

        @NotBlank(message = "Insira o país de origen do cliente")
        String pais,

        @NotBlank(message = "Insira o CEP do cliente")
        String CEP,

        String CPF,
        String CNPJ
) {
}
