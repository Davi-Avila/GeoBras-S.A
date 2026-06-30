package com.example.geobras.service;

import com.example.geobras.dto.ClienteRequestDTO;
import com.example.geobras.dto.ClienteResponseDTO;
import com.example.geobras.exception.RecursoNaoEncontradoException;
import com.example.geobras.model.Cliente;
import com.example.geobras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteResponseDTO> listar(){
        return clienteRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(dto.nomeCliente());
        cliente.setEmail(dto.email());
        cliente.setPais(dto.pais());
        cliente.setCEP(dto.CEP());
        cliente.setCPF(dto.CPF());
        cliente.setCNPJ(dto.CNPJ());

        Cliente salvo =clienteRepository.save(cliente);
        return toResponseDTO(salvo);
    }

    public ClienteResponseDTO atualizar(Long idCliente, ClienteRequestDTO dto){
        Cliente existente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        existente.setNomeCliente(dto.nomeCliente());
        existente.setEmail(dto.email());
        existente.setPais(dto.pais());
        existente.setCEP(dto.CEP());
        existente.setCPF(dto.CPF());
        existente.setCNPJ(dto.CNPJ());

        Cliente atualizado = clienteRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long idCliente){
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    public ClienteResponseDTO buscarPorId(Long idCliente){
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        return toResponseDTO(cliente);
    }


    private ClienteResponseDTO toResponseDTO(Cliente cliente){
        return new ClienteResponseDTO(
                cliente.getIdCliente(),
                cliente.getNomeCliente(),
                cliente.getEmail(),
                cliente.getPais(),
                cliente.getCEP(),
                cliente.getCPF(),
                cliente.getCNPJ()
        );
    }

    public Cliente buscarEntidade(Long idCliente){
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
    }
}
