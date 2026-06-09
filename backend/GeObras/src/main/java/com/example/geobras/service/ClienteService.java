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
    @Autowired
    private ClienteRepository clienteRepository;

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
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        cliente.setNomeCliente(dto.nomeCliente());
        cliente.setEmail(dto.email());
        cliente.setPais(dto.pais());
        cliente.setCEP(dto.CEP());
        cliente.setCPF(dto.CPF());
        cliente.setCNPJ(dto.CNPJ());

        Cliente atualizado = clienteRepository.save(cliente);
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
                cliente.getNomeCliente(),
                cliente.getEmail(),
                cliente.getPais(),
                cliente.getCEP(),
                cliente.getCPF(),
                cliente.getCNPJ()
        );
    }
}
