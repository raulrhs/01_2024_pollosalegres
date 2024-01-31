package com.sinensia.pollosfelices.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.pollosfelices.backend.business.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
