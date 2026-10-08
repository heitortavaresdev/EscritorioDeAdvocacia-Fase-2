package com.exemplo.escritorio.controller;

import com.exemplo.escritorio.model.Documento;
import com.exemplo.escritorio.service.DocumentoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping
    public List<Documento> listar() {
        return documentoService.listar();
    }

    @PostMapping
    public Documento adicionar(@RequestBody Documento documento) {
        return documentoService.adicionar(documento);
    }

    @PutMapping("/{id}")
    public Documento atualizar(@PathVariable Long id, @RequestBody Documento documento) {
        return documentoService.atualizar(id, documento);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        documentoService.remover(id);
    }
}