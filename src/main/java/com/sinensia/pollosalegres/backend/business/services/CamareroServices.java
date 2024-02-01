package com.sinensia.pollosalegres.backend.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.pollosalegres.backend.business.model.Camarero;

public interface CamareroServices {
	
	/**
	 * Lanza IllegalStateException si:
	 * 
	 * - El camarero tiene dni null
	 * - El camarero tiene id NO null
	 * - Ya existe un camarero con el mismo dni
	 * 
	 */
	Long create(Camarero camarero);

	Optional<Camarero> read(Long id);
	Optional<Camarero> read(String dni);
	
	void update(Camarero camarero);
	void delete(Long id);
	
	List<Camarero> getAll();
	List<Camarero> getByNombreLikeIgnoreCase(String texto);
	
	int getNumeroTotalCamareros();

}
