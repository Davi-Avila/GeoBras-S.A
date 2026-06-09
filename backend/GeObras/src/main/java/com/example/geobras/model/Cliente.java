package com.example.geobras.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;
    private String email;
    private String pais;
    private String CEP;
    private String CPF;
    private String CNPJ;

    @OneToMany(mappedBy = "cliente")
    private List<Obra> obras = new ArrayList<>();

}
