package com.example.geobras.dto;

public record MaterialResponseDTO(
        Long idMaterial,
        String nomeMaterial,
        Double valorMaterial,
        Integer quantidade,
        Long id
) {
}
