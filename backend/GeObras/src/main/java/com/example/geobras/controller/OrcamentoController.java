package com.example.geobras.controller;

import com.example.geobras.dto.OrcamentoRequestDTO;
import com.example.geobras.dto.OrcamentoResponseDTO;
import com.example.geobras.service.OrcamentoService;
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

    @GetMapping
    public List<OrcamentoResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public OrcamentoResponseDTO salvar(@RequestBody @Valid OrcamentoRequestDTO dto){
        return service.salvar(dto);
    }
    @PutMapping("/{id}")
    public OrcamentoResponseDTO atualizar(@RequestBody @Valid OrcamentoRequestDTO dto, @PathVariable Long id){
        return service.atualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
