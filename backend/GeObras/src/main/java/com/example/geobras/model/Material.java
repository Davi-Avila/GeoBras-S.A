package com.example.geobras.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMaterial;
    private Double valorMaterial;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "idOrcamento")
    private Orcamento orcamento;

    public Material(){}

}
