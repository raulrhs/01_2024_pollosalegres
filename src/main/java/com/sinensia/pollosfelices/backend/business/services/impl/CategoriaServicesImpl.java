package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.services.CategoriaServices;

public class CategoriaServicesImpl implements CategoriaServices {

	private final Map<Long, Categoria> CATEGORIAS_DB = new HashMap<>();
	
	public CategoriaServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Categoria> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Categoria> getAll() {
		return new ArrayList<>(CATEGORIAS_DB.values());
	}
	
	// *************************************************
	//
	// Private Methods
	//
	// *************************************************

	private void init() {
		
		Categoria c1 = new Categoria();
		c1.setId(1L);
		c1.setNombre("TAPA");
		
		Categoria c2 = new Categoria();
		c2.setId(2L);
		c2.setNombre("REFRESCO");
		
		Categoria c3 = new Categoria();
		c3.setId(3L);
		c3.setNombre("CERVEZA");
		
		Categoria c4 = new Categoria();
		c4.setId(4L);
		c4.setNombre("CAFE");
		
		Categoria c5 = new Categoria();
		c5.setId(5L);
		c5.setNombre("LICOR");
		
		Categoria c6 = new Categoria();
		c6.setId(6L);
		c6.setNombre("AGUA");
		
		Categoria c7 = new Categoria();
		c7.setId(7L);
		c7.setNombre("BOCATA");
		
		Categoria c8 = new Categoria();
		c8.setId(8L);
		c8.setNombre("POSTRE");
		
		Categoria c9 = new Categoria();
		c9.setId(9L);
		c9.setNombre("INFUSIÓN");
		
		CATEGORIAS_DB.put(c1.getId(), c1);
		CATEGORIAS_DB.put(c2.getId(), c2);
		CATEGORIAS_DB.put(c3.getId(), c3);
		CATEGORIAS_DB.put(c4.getId(), c4);
		CATEGORIAS_DB.put(c5.getId(), c5);
		CATEGORIAS_DB.put(c6.getId(), c6);
		CATEGORIAS_DB.put(c7.getId(), c7);
		CATEGORIAS_DB.put(c8.getId(), c8);
		CATEGORIAS_DB.put(c9.getId(), c9);
	
	}
}
