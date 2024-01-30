package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.services.CategoriaServices;

@Service
public class CategoriaServicesImpl implements CategoriaServices {

	private final Map<Long, Categoria> CATEGORIAS = new HashMap<>();
	
	public CategoriaServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Categoria categoria) {
		
		if(categoria.getId() != null) {
			throw new IllegalStateException("Para crear una categoria el id ha de ser null");
		}
		
		Long id = System.currentTimeMillis();
		
		categoria.setId(id);
		
		CATEGORIAS.put(id, categoria);
	
		return id;
	}

	@Override
	public Optional<Categoria> read(Long id) {
		return Optional.ofNullable(CATEGORIAS.get(id));
	}

	@Override
	public List<Categoria> getAll() {
		return new ArrayList<>(CATEGORIAS.values());
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
		
		CATEGORIAS.put(c1.getId(), c1);
		CATEGORIAS.put(c2.getId(), c2);
		CATEGORIAS.put(c3.getId(), c3);
		CATEGORIAS.put(c4.getId(), c4);
		CATEGORIAS.put(c5.getId(), c5);
		CATEGORIAS.put(c6.getId(), c6);
		CATEGORIAS.put(c7.getId(), c7);
		CATEGORIAS.put(c8.getId(), c8);
		CATEGORIAS.put(c9.getId(), c9);
	}
}
