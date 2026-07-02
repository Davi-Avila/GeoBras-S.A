package com.example.geobras.repository;

import com.example.geobras.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    @Query("SELECT o FROM Orcamento o WHERE o.obra IS NULL")
    List<Orcamento> buscarOrcamentosDisponiveis();
}
