package com.example.geobras.controller;

import com.example.geobras.dto.MaterialResponseDTO;
import com.example.geobras.service.MaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<MaterialResponseDTO> lista(){
        return materialService.listar();
    }

    @DeleteMapping("/{idMaterial}")
    public void deletar(@PathVariable Long idMaterial){
        materialService.deletar(idMaterial);
    }

    @GetMapping("/{idMaterial}")
    public MaterialResponseDTO buscarPorId(@PathVariable Long idMaterial){
        return materialService.buscarPorId(idMaterial);
    }



}
