package com.example.geobras.service;

import com.example.geobras.dto.MaterialRequestDTO;
import com.example.geobras.dto.MaterialResponseDTO;
import com.example.geobras.exception.RecursoNaoEncontradoException;
import com.example.geobras.model.Material;
import com.example.geobras.model.Orcamento;
import com.example.geobras.repository.MaterialRepository;

import java.util.List;

public class MaterialService {
    private final MaterialRepository materialRepository;
    private final OrcamentoService orcamentoService;

    public MaterialService(MaterialRepository repository, OrcamentoService orcamentoService) {
        this.materialRepository = repository;
        this.orcamentoService = orcamentoService;
    }

    public List<MaterialResponseDTO> listar(){
        return materialRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public MaterialResponseDTO salvar(MaterialRequestDTO dto){
        Material material = new Material();
        Orcamento orcamento = orcamentoService.buscarEntidade(dto.idOrcamento());
        material.setNomeMaterial(dto.nomeMaterial());
        material.setValorMaterial(dto.valorMaterial());
        material.setQuantidade(dto.quantidade());
        material.setOrcamento(orcamento);

        Material salvo = materialRepository.save(material);
        return toResponse(salvo);

    }



    public void deletar(Long idMaterial){
        Material material = materialRepository.findById(idMaterial)
        .orElseThrow(()-> new RecursoNaoEncontradoException("Material não encontrado"));

        materialRepository.delete(material);
    }

    public MaterialResponseDTO buscarPorId(Long idMaterial){
        Material material = materialRepository.findById(idMaterial)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Material não encontrado"));

        return toResponse(material);

    }

    private MaterialResponseDTO toResponse(Material material){
        return new MaterialResponseDTO(
            material.getIdMaterial(),
            material.getNomeMaterial(),
            material.getValorMaterial(),
            material.getQuantidade(),
            material.getOrcamento().getId()
        );
    }
}
