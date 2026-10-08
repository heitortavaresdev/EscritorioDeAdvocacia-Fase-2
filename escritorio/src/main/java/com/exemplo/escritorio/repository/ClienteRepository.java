package com.exemplo.escritorio.repository;

import com.exemplo.escritorio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}