package com.example.geobras.controller;

import com.example.geobras.dto.OrcamentoRequestDTO;
import com.example.geobras.dto.OrcamentoResponseDTO;
import com.example.geobras.service.OrcamentoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

    private final OrcamentoService service;

    public OrcamentoController(OrcamentoService service){
        this.service = service;
    }

    @Operation(summary = "", description = "Lista todos os orçamentos cadastrados")
    @GetMapping
    public List<OrcamentoResponseDTO> listar(){
        return service.listar();
    }

    @Operation(summary = "", description = "")
    @GetMapping("/{id}")
    public OrcamentoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "", description = "")
    @PostMapping
    public OrcamentoResponseDTO salvar(@RequestBody @Valid OrcamentoRequestDTO dto){
        return service.salvar(dto);
    }

    @Operation(summary = "", description = "")
    @PutMapping("/{id}")
    public OrcamentoResponseDTO atualizar(@RequestBody @Valid OrcamentoRequestDTO dto, @PathVariable Long id){
        return service.atualizar(id,dto);
    }

    @Operation(summary = "", description = "Deleta um orçamento existente")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
