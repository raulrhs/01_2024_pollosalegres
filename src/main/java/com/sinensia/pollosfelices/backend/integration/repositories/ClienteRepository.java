package com.sinensia.pollosfelices.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.pollosfelices.backend.business.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
