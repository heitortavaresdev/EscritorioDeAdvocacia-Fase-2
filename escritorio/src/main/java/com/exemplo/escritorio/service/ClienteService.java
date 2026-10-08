package com.exemplo.escritorio.service;

import com.exemplo.escritorio.model.Cliente;
import com.exemplo.escritorio.model.Documento;
import com.exemplo.escritorio.repository.ClienteRepository;
import com.exemplo.escritorio.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final DocumentoRepository documentoRepository;

    public ClienteService(ClienteRepository clienteRepository, DocumentoRepository documentoRepository) {
        this.clienteRepository = clienteRepository;
        this.documentoRepository = documentoRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente adicionar(Cliente cliente) {
        if (!buscarDocumento(cliente)) {
            return null;
        }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id) || !buscarDocumento(cliente)) {
            return null;
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    private boolean buscarDocumento(Cliente cliente) {
        if (cliente.getDocumento() == null) {
            return true;
        }
        Documento documento = documentoRepository.findById(cliente.getDocumento().getId()).orElse(null);
        if (documento == null) {
            return false;
        }
        cliente.setDocumento(documento);
        return true;
    }
}