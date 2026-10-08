package com.exemplo.escritorio.service;

import com.exemplo.escritorio.model.Documento;
import com.exemplo.escritorio.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public List<Documento> listar() {
        return documentoRepository.findAll();
    }

    public Documento adicionar(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento atualizar(Long id, Documento documento) {
        if (!documentoRepository.existsById(id)) {
            return null;
        }
        documento.setId(id);
        return documentoRepository.save(documento);
    }

    public void remover(Long id) {
        documentoRepository.deleteById(id);
    }
}