package com.example.geobras.service;

import com.example.geobras.dto.ObraRequestDTO;
import com.example.geobras.dto.ObraResponseDTO;
import com.example.geobras.exception.RecursoNaoEncontradoException;
import com.example.geobras.model.Cliente;
import com.example.geobras.model.Obra;
import com.example.geobras.model.Orcamento;
import com.example.geobras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    private final ObraRepository obraRepository;
    private final ClienteService clienteService;
    private final OrcamentoService orcamentoService;

    public ObraService(ObraRepository obraRepository, ClienteService clienteService, OrcamentoService orcamentoService){
        this.obraRepository = obraRepository;
        this.clienteService = clienteService;
        this.orcamentoService = orcamentoService;
    }

    public List<ObraResponseDTO> listar(){
        return obraRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ObraResponseDTO salvar(ObraRequestDTO dto){
        Orcamento orcamento = orcamentoService.buscarEntidade(dto.idOrcamento());
        Cliente cliente = clienteService.buscarEntidade(dto.idCliente());
        Obra obra = new Obra();
        obra.setNomeObra(dto.nomeObra());
        obra.setEndereco(dto.endereco());
        obra.setDataInicio(dto.dataInicio());
        obra.setDataFimPrevisto(dto.dataFimPrevisto());
        obra.setEtapa(dto.etapa());
        obra.setOrcamento(orcamento);
        obra.setCliente(cliente);

        Obra salvo = obraRepository.save(obra);
        return toResponseDTO(salvo);

    }

    public ObraResponseDTO atualizar(Long idObra, ObraRequestDTO dto){
        Obra existente = obraRepository.findById(idObra)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Obra não encontrada"));

        Orcamento orcamento = orcamentoService.buscarEntidade(dto.idOrcamento());
        Cliente cliente = clienteService.buscarEntidade(dto.idCliente());
        existente.setNomeObra(dto.nomeObra());
        existente.setEndereco(dto.endereco());
        existente.setDataInicio(dto.dataInicio());
        existente.setDataFimPrevisto(dto.dataFimPrevisto());
        existente.setEtapa(dto.etapa());
        existente.setOrcamento(orcamento);
        existente.setCliente(cliente);

        Obra atualizado = obraRepository.save(existente);
        return toResponseDTO(atualizado);

    }

    public void deletar(Long idObra){
        Obra obra = obraRepository.findById(idObra)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Obra não encontrada"));

        obraRepository.delete(obra);
    }

    public ObraResponseDTO buscarPorId(Long idObra){
        Obra obra = obraRepository.findById(idObra)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Obra não encontrada"));

        return toResponseDTO(obra);
    }

    private ObraResponseDTO toResponseDTO(Obra obra){
        return new ObraResponseDTO(
                obra.getIdObra(),
                obra.getNomeObra(),
                obra.getEndereco(),
                obra.getDataInicio(),
                obra.getDataFimPrevisto(),
                obra.getEtapa(),
                obra.getOrcamento().getOrcamentoTotal(),
                obra.getCliente().getNomeCliente(),
                obra.getCliente().getEmail()
        );
    }
}
