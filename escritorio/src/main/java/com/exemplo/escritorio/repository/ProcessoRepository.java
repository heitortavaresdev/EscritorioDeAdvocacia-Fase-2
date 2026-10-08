package com.exemplo.escritorio.repository;

import com.exemplo.escritorio.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}