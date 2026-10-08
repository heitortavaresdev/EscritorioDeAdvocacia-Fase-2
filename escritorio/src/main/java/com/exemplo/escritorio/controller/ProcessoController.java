package com.exemplo.escritorio.controller;

import com.exemplo.escritorio.model.Processo;
import com.exemplo.escritorio.service.ProcessoService;
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
@RequestMapping("/processos")
public class ProcessoController {

    private final ProcessoService processoService;

    public ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }

    @GetMapping
    public List<Processo> listar() {
        return processoService.listar();
    }

    @PostMapping
    public Processo adicionar(@RequestBody Processo processo) {
        return processoService.adicionar(processo);
    }

    @PutMapping("/{id}")
    public Processo atualizar(@PathVariable Long id, @RequestBody Processo processo) {
        return processoService.atualizar(id, processo);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        processoService.remover(id);
    }
}