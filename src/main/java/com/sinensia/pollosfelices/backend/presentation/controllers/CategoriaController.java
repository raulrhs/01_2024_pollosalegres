package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.services.CategoriaServices;
import com.sinensia.pollosfelices.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaServices categoriaServices;
	
	public CategoriaController(CategoriaServices categoriaServices) {
		this.categoriaServices = categoriaServices;
	}
	
	@GetMapping
	public List<Categoria> getCategorias(){
		return categoriaServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Categoria read(@PathVariable Long id) {
	
		Optional<Categoria> optional = categoriaServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe la categoria " + id, HttpStatus.NOT_FOUND);	
		}
		
		return optional.get();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Categoria categoria, UriComponentsBuilder ucb) {
		
		Long nuevoId = null;
		
		try {
			nuevoId = categoriaServices.create(categoria);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		URI uri = ucb.path("/categorias/{id}").build(nuevoId);
		
		return ResponseEntity.created(uri).build();
	}

}
