package com.example.geobras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObra;

    private String nomeObra;
    private String endereco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFimPrevisto;

    private String etapa;

    @OneToOne
    @JoinColumn(name = "idOrcamento")
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;


}
