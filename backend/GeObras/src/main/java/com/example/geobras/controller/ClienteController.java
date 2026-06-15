package com.example.geobras.controller;

import com.example.geobras.dto.ClienteRequestDTO;
import com.example.geobras.dto.ClienteResponseDTO;
import com.example.geobras.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;             //DIFERENÇA DAS BRANCHS

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Lista cliente", description = "Lista todos os clientes cadastrados")
    @GetMapping
    public List<ClienteResponseDTO> listar(){
        return clienteService.listar();
    }

    @Operation(summary = "Salvar cliente", description = "Salva um novo cliente")
    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody @Valid ClienteRequestDTO dto){
        return clienteService.salvar(dto);
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza um cliente existente")
    @PutMapping("/{idCliente}")
    public ClienteResponseDTO atualizar(@PathVariable Long idCliente, @RequestBody @Valid ClienteRequestDTO dto){
        return clienteService.atualizar(idCliente, dto);
    }

    @Operation(summary = "Deletar cliente", description = "Deleta um cliente existente")
    @DeleteMapping("/{idCliente}")
    public void deletar(@PathVariable Long idCliente){
        clienteService.deletar(idCliente);
    }

    @Operation(summary = "Buscar po id", description = "Busca o cliente pelo id")
    @GetMapping("/{idCliente}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long idCliente){
        return clienteService.buscarPorId(idCliente);
    }

}
