package com.example.geobras.service;

import com.example.geobras.dto.ObraResponseDTO;
import com.example.geobras.dto.OrcamentoRequestDTO;
import com.example.geobras.dto.OrcamentoResponseDTO;
import com.example.geobras.exception.RecursoNaoEncontradoException;
import com.example.geobras.model.Orcamento;
import com.example.geobras.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {
    private final OrcamentoRepository repository;

    public OrcamentoService(OrcamentoRepository repository){
        this.repository = repository;
    }

    private OrcamentoResponseDTO toResponseDTO(Orcamento orcamento){
        return new OrcamentoResponseDTO(
                orcamento.getDeslocamento(),
                orcamento.getMaoDeObra(),
                orcamento.getServico(),
                orcamento.getAluguelDeEquipamento(),
                orcamento.getImposto(),
                calcularOrcamentoTotal(orcamento.getImposto(),orcamento.getAluguelDeEquipamento(), orcamento.getDeslocamento())
        );
    }

    public OrcamentoResponseDTO salvar(OrcamentoRequestDTO dto){
        Orcamento orcamento = new Orcamento();
        orcamento.setDeslocamento(dto.deslocamento());
        orcamento.setMaoDeObra(dto.maoDeObra());
        orcamento.setServico(dto.servico());
        orcamento.setAluguelDeEquipamento(dto.aluguelDeEquipamento());
        orcamento.setImposto(dto.imposto());
        orcamento.setOrcamentoTotal(calcularOrcamentoTotal(dto.imposto(),dto.aluguelDeEquipamento(), dto.deslocamento()));

        Orcamento salvo = repository.save(orcamento);
        return toResponseDTO(salvo);
    }

    public List<OrcamentoResponseDTO> listar(){
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public OrcamentoResponseDTO atualizar(Long id, OrcamentoRequestDTO dto){
        Orcamento orcamento = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Orçamento não encontrado !!"));

        orcamento.setDeslocamento(dto.deslocamento());
        orcamento.setMaoDeObra(dto.maoDeObra());
        orcamento.setServico(dto.servico());
        orcamento.setAluguelDeEquipamento(dto.aluguelDeEquipamento());
        orcamento.setImposto(dto.imposto());
        orcamento.setOrcamentoTotal(calcularOrcamentoTotal(dto.imposto(), dto.aluguelDeEquipamento(), dto.deslocamento()));

        Orcamento  atualizado = repository.save(orcamento);

        return toResponseDTO(atualizado);
    }
    private  Double calcularOrcamentoTotal(Double imposto, Double aluguel, Double deslocamento){
        Double valor = ( aluguel + imposto + deslocamento);
        return valor;
    }

}
