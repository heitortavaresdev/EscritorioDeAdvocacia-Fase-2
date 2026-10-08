package com.exemplo.escritorio.repository;

import com.exemplo.escritorio.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}