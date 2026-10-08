package com.exemplo.escritorio.service;

import com.exemplo.escritorio.model.Advogado;
import com.exemplo.escritorio.model.Cliente;
import com.exemplo.escritorio.model.Processo;
import com.exemplo.escritorio.repository.AdvogadoRepository;
import com.exemplo.escritorio.repository.ClienteRepository;
import com.exemplo.escritorio.repository.ProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvogadoService {

    private final AdvogadoRepository advogadoRepository;
    private final ProcessoRepository processoRepository;
    private final ClienteRepository clienteRepository;

    public AdvogadoService(AdvogadoRepository advogadoRepository, ProcessoRepository processoRepository,
                           ClienteRepository clienteRepository) {
        this.advogadoRepository = advogadoRepository;
        this.processoRepository = processoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Advogado> listar() {
        return advogadoRepository.findAll();
    }

    public Advogado adicionar(Advogado advogado) {
        if (!buscarRelacionados(advogado)) {
            return null;
        }
        return advogadoRepository.save(advogado);
    }

    public Advogado atualizar(Long id, Advogado advogado) {
        if (!advogadoRepository.existsById(id) || !buscarRelacionados(advogado)) {
            return null;
        }
        advogado.setId(id);
        return advogadoRepository.save(advogado);
    }

    public void remover(Long id) {
        advogadoRepository.deleteById(id);
    }

    private boolean buscarRelacionados(Advogado advogado) {
        List<Processo> processos = new ArrayList<>();
        for (Processo item : advogado.getProcessos()) {
            Processo processo = processoRepository.findById(item.getId()).orElse(null);
            if (processo == null) {
                return false;
            }
            processos.add(processo);
        }
        advogado.setProcessos(processos);

        List<Cliente> clientes = new ArrayList<>();
        for (Cliente item : advogado.getClientes()) {
            Cliente cliente = clienteRepository.findById(item.getId()).orElse(null);
            if (cliente == null) {
                return false;
            }
            clientes.add(cliente);
        }
        advogado.setClientes(clientes);
        return true;
    }
}