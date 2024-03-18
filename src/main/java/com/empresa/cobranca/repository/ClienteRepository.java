package com.empresa.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.cobranca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
