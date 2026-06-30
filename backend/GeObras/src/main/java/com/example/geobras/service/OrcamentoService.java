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
                orcamento.getIdOrcamento(),
                orcamento.getDeslocamento(),
                orcamento.getMaoDeObra(),
                orcamento.getServico(),
                orcamento.getAluguelDeEquipamento(),
                orcamento.getSomaMateriais(),
                orcamento.getImposto(),
                calcularOrcamentoTotal(orcamento.getImposto(),orcamento.getAluguelDeEquipamento(), orcamento.getDeslocamento(), orcamento.getMaoDeObra(), orcamento.getSomaMateriais())
        );
    }

    public OrcamentoResponseDTO salvar(OrcamentoRequestDTO dto){
        Orcamento orcamento = new Orcamento();
        orcamento.setDeslocamento(dto.deslocamento());
        orcamento.setMaoDeObra(dto.maoDeObra());
        orcamento.setServico(dto.servico());
        orcamento.setAluguelDeEquipamento(dto.aluguelDeEquipamento());
        orcamento.setSomaMateriais(dto.somaMateriais());
        orcamento.setImposto(dto.imposto());
        orcamento.setOrcamentoTotal(calcularOrcamentoTotal(dto.imposto(),dto.aluguelDeEquipamento(), dto.deslocamento(), dto.maoDeObra(), dto.somaMateriais()));

        Orcamento salvo = repository.save(orcamento);
        return toResponseDTO(salvo);
    }

    public List<OrcamentoResponseDTO> listar(){
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public OrcamentoResponseDTO buscarPorId(Long idOrcamento){
        Orcamento orcamento = repository.findById(idOrcamento).orElseThrow(() -> new RecursoNaoEncontradoException("Orçamento não encontrado !!"));

        return toResponseDTO(orcamento);
    }

    public OrcamentoResponseDTO atualizar(Long idOrcamento, OrcamentoRequestDTO dto){
        Orcamento orcamento = repository.findById(idOrcamento).orElseThrow(() -> new RecursoNaoEncontradoException("Orçamento não encontrado !!"));

        orcamento.setDeslocamento(dto.deslocamento());
        orcamento.setMaoDeObra(dto.maoDeObra());
        orcamento.setServico(dto.servico());
        orcamento.setAluguelDeEquipamento(dto.aluguelDeEquipamento());
        orcamento.setSomaMateriais(dto.somaMateriais());
        orcamento.setImposto(dto.imposto());
        orcamento.setOrcamentoTotal(calcularOrcamentoTotal(dto.imposto(), dto.aluguelDeEquipamento(), dto.deslocamento(), dto.maoDeObra(), dto.somaMateriais()));

        Orcamento  atualizado = repository.save(orcamento);

        return toResponseDTO(atualizado);
    }
    public void deletar(Long idOrcamento){
        Orcamento orcamento = repository.findById(idOrcamento).orElseThrow(() ->new RecursoNaoEncontradoException("Orçamento não encontrado !!"));
        
        repository.delete(orcamento);
    }
    private  Double calcularOrcamentoTotal(Double imposto, Double aluguel, Double deslocamento, Double maoDeObra, Double somaMateriais){
        imposto *= 0.01;
        Double valor = (maoDeObra + aluguel + somaMateriais) + (deslocamento * 1.50);
        valor += (valor * imposto);
        return valor;
    }

    public Orcamento buscarEntidade(Long idOrcamento){
        return repository.findById(idOrcamento)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Orçamento não encontrado"));
    }

}
