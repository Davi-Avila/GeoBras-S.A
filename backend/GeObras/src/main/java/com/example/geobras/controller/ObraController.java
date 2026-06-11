package com.example.geobras.controller;

import com.example.geobras.dto.ObraRequestDTO;
import com.example.geobras.dto.ObraResponseDTO;
import com.example.geobras.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{obras}")
public class ObraController {
    @Autowired
    private ObraService obraService;

    @GetMapping
    public List<ObraResponseDTO> listar(){
        return obraService.listar();
    }

    @PostMapping
    public ObraResponseDTO salvar(@RequestBody @Valid ObraRequestDTO dto){
        return obraService.salvar(dto);
    }

    @PutMapping("/{idObra}")
    public ObraResponseDTO atualizar(@PathVariable Long idObra, @RequestBody @Valid ObraRequestDTO dto){
        return obraService.atualizar(idObra, dto);
    }

    @DeleteMapping("/{idObra}")
    public void deletar(@PathVariable Long idObra){
        obraService.deletar(idObra);
    }

    @GetMapping("/{idObra}")
    public ObraResponseDTO buscarPorId(@PathVariable Long idObra){
        return obraService.buscarPorId(idObra);
    }

}
