package com.example.geobras.service;

import com.example.geobras.dto.ObraResponseDTO;
import com.example.geobras.exception.RecursoNaoEncontradoException;
import com.example.geobras.model.Obra;
import com.example.geobras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    @Autowired
    private ObraRepository obraRepository;

    public List<ObraResponseDTO> listar(){
        return obraRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long idObra){
        Obra obra = obraRepository.findById(idObra)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Obra não encontrada"));

        obraRepository.delete(obra);
    }

    private ObraResponseDTO toResponseDTO(Obra obra){
        return new ObraResponseDTO(
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
