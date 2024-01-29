package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.pollosfelices.backend.business.model.Camarero;
import com.sinensia.pollosfelices.backend.business.services.CamareroServices;
import com.sinensia.pollosfelices.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/camareros")
public class CamareroController {

	private CamareroServices camareroServices;
	
	public CamareroController(CamareroServices camareroServices) {
		this.camareroServices = camareroServices;
	}
	
	@GetMapping
	public List<Camarero> getCamareros(@RequestParam(required = false) String nombre){
		
		List<Camarero> camareros = null;
		
		if(nombre == null) {
			camareros = camareroServices.getAll();
		} else {
			camareros = camareroServices.getByNombreLikeIgnoreCase(nombre);
		}
		
		return camareros;
	}
	
	@GetMapping("/{id}")
	public Camarero read(@PathVariable Long id) {
	
		Optional<Camarero> optional = camareroServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el camarero " + id, HttpStatus.NOT_FOUND);	
		}
		
		return optional.get();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Camarero camarero, UriComponentsBuilder ucb) {
		
		Long nuevoId = null;
		
		try {
			nuevoId = camareroServices.create(camarero);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		URI uri = ucb.path("/camareros/{id}").build(nuevoId);
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Camarero camarero, @PathVariable Long id) {
		
		camarero.setId(id);
		
		try {
			camareroServices.update(camarero);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		try {
			camareroServices.delete(id);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
			
}
