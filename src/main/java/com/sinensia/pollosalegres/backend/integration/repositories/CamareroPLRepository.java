package com.sinensia.pollosalegres.backend.integration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.pollosalegres.backend.integration.model.CamareroPL;

public interface CamareroPLRepository extends JpaRepository<CamareroPL, Long>{

	Optional<CamareroPL> findByDni(String dni);
	
	List<CamareroPL> findByNombreLikeIgnoreCaseOrderById(String nombre);
	
	boolean existsByDni(String dni);
}
