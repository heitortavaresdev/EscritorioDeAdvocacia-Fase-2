package com.exemplo.escritorio.service;

import com.exemplo.escritorio.model.Cliente;
import com.exemplo.escritorio.model.Processo;
import com.exemplo.escritorio.repository.ClienteRepository;
import com.exemplo.escritorio.repository.ProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final ClienteRepository clienteRepository;

    public ProcessoService(ProcessoRepository processoRepository, ClienteRepository clienteRepository) {
        this.processoRepository = processoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Processo> listar() {
        return processoRepository.findAll();
    }

    public Processo adicionar(Processo processo) {
        if (!buscarCliente(processo)) {
            return null;
        }
        return processoRepository.save(processo);
    }

    public Processo atualizar(Long id, Processo processo) {
        if (!processoRepository.existsById(id) || !buscarCliente(processo)) {
            return null;
        }
        processo.setId(id);
        return processoRepository.save(processo);
    }

    public void remover(Long id) {
        processoRepository.deleteById(id);
    }

    private boolean buscarCliente(Processo processo) {
        if (processo.getCliente() == null) {
            return true;
        }
        Cliente cliente = clienteRepository.findById(processo.getCliente().getId()).orElse(null);
        if (cliente == null) {
            return false;
        }
        processo.setCliente(cliente);
        return true;
    }
}