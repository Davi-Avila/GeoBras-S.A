package com.example.geobras.controller;

import com.example.geobras.dto.MaterialRequestDTO;
import com.example.geobras.dto.MaterialResponseDTO;
import com.example.geobras.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService){
        this.materialService = materialService;
    }

    @Operation(summary = "Listar material", description = "Lista todos os materiais cadastrados")
    @GetMapping
    public List<MaterialResponseDTO> listar(){
        return materialService.listar();
    }

    @Operation(summary = "Salvar material", description = "Salva um novo material")
    @PostMapping
    public MaterialResponseDTO salvar(@RequestBody @Valid MaterialRequestDTO dto){
        return materialService.salvar(dto);
    }
    /*
    @PutMapping
    public MaterialResponseDTO atualizar(@PathVariable Long idMaterial, @RequestBody @Valid MaterialRequestDTO dto){
        return materialService.atualizar(
    }
    */
    @Operation(summary = "Deletar material", description = "Deleta um material existente")
    @DeleteMapping("/{idMaterial}")
    public void deletar(@PathVariable Long idMaterial){
        materialService.deletar(idMaterial);
    }

    @Operation(summary = "Buscar por id", description = "Busca o material pelo id")
    @GetMapping("/{idMaterial}")
    public MaterialResponseDTO buscarPorId(@PathVariable Long idMaterial){
        return materialService.buscarPorId(idMaterial);
    }



}
