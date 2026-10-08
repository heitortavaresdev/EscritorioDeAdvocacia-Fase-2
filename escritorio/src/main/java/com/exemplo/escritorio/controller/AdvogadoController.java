package com.exemplo.escritorio.controller;

import com.exemplo.escritorio.model.Advogado;
import com.exemplo.escritorio.service.AdvogadoService;
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
@RequestMapping("/advogados")
public class AdvogadoController {

    private final AdvogadoService advogadoService;

    public AdvogadoController(AdvogadoService advogadoService) {
        this.advogadoService = advogadoService;
    }

    @GetMapping
    public List<Advogado> listar() {
        return advogadoService.listar();
    }

    @PostMapping
    public Advogado adicionar(@RequestBody Advogado advogado) {
        return advogadoService.adicionar(advogado);
    }

    @PutMapping("/{id}")
    public Advogado atualizar(@PathVariable Long id, @RequestBody Advogado advogado) {
        return advogadoService.atualizar(id, advogado);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        advogadoService.remover(id);
    }
}