package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.services.CategoriaServices;
import com.sinensia.pollosfelices.backend.integration.model.CategoriaPL;
import com.sinensia.pollosfelices.backend.integration.repositories.CategoriaPLRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServicesImpl implements CategoriaServices{

	@Autowired
	private DozerBeanMapper mapper;
	
	private CategoriaPLRepository categoriaPLRepository;
	
	public CategoriaServicesImpl(CategoriaPLRepository categoriaRepository) {
		this.categoriaPLRepository = categoriaRepository;
	}
	
	@Override
	@Transactional
	public Long create(Categoria categoria) {
	
		if(categoria.getId() != null) {
			throw new IllegalStateException("Para crear una categoria el id ha de ser null");
		}
		
		CategoriaPL categoriaPL = mapper.map(categoria, CategoriaPL.class);
		categoriaPL.setId(System.currentTimeMillis());
		
		CategoriaPL createdCategoriaPL = categoriaPLRepository.save(categoriaPL);
		
		return createdCategoriaPL.getId();
	}

	@Override
	public Optional<Categoria> read(Long id) {
		
		Optional<CategoriaPL> optional = categoriaPLRepository.findById(id);
		
		Categoria categoria = null;
		
		if(optional.isPresent()) {
			categoria = mapper.map(categoria, Categoria.class);
		}
		
		return Optional.ofNullable(categoria);	
	}

	@Override
	public List<Categoria> getAll() {
		
		return categoriaPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Categoria.class))
				.toList();
				
	}

}
