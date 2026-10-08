package com.exemplo.escritorio.repository;

import com.exemplo.escritorio.model.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvogadoRepository extends JpaRepository<Advogado, Long> {
}