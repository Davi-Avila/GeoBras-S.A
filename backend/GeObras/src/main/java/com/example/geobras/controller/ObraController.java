package com.example.geobras.controller;

import com.example.geobras.dto.ObraRequestDTO;
import com.example.geobras.dto.ObraResponseDTO;
import com.example.geobras.service.ObraService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {
    @Autowired
    private ObraService obraService;

    @Operation(summary = "Listar obra", description = "Lista todas as obras cadastradas")
    @GetMapping
    public List<ObraResponseDTO> listar(){
        return obraService.listar();
    }

    @Operation(summary = "Salvar obra", description = "Salva uma nova obra")
    @PostMapping
    public ObraResponseDTO salvar(@RequestBody @Valid ObraRequestDTO dto){
        return obraService.salvar(dto);
    }

    @Operation(summary = "Atualizar obra", description = "Atualiza uma obra existente")
    @PutMapping("/{idObra}")
    public ObraResponseDTO atualizar(@PathVariable Long idObra, @RequestBody @Valid ObraRequestDTO dto){
        return obraService.atualizar(idObra, dto);
    }

    @Operation(summary = "Deletar obra", description = "Deleta uma obra existente")
    @DeleteMapping("/{idObra}")
    public void deletar(@PathVariable Long idObra){
        obraService.deletar(idObra);
    }

    @Operation(summary = "Buscar por id", description = "Busca a obra pelo id")
    @GetMapping("/{idObra}")
    public ObraResponseDTO buscarPorId(@PathVariable Long idObra){
        return obraService.buscarPorId(idObra);
    }

}
