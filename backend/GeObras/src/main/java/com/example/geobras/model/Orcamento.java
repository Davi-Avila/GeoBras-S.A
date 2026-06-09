package com.example.geobras.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double deslocamento;
    private String material;
    private Integer maoDeObra;
    private String servico;
    private Double aluguelDeEquipamento;
    private Double imposto;


}
