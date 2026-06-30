package com.example.geobras.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrcamento;

    private Double deslocamento;
    private Double maoDeObra;
    private String servico;
    private Double aluguelDeEquipamento;
    private Double imposto;
    private Double orcamentoTotal;

    @OneToMany(mappedBy = "orcamento")
    private List<Material> materiais = new ArrayList<>();

    public Orcamento(){}
}
