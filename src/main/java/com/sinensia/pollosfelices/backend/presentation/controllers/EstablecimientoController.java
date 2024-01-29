package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.pollosfelices.backend.business.model.Establecimiento;
import com.sinensia.pollosfelices.backend.business.services.EstablecimientoServices;
import com.sinensia.pollosfelices.backend.presentation.config.RespuestaError;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {

	@Autowired
	private EstablecimientoServices establecimientoServices;
	
	@GetMapping
	public List<Establecimiento> getAll(){
		return establecimientoServices.getAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> read(@PathVariable Long codigo) {
	
		Optional<Establecimiento> optional = establecimientoServices.read(codigo);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			RespuestaError respuestaError = new RespuestaError("No existe el establecimiebto " + codigo);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuestaError);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Establecimiento establecimiento, UriComponentsBuilder ucb) {
		
		Long nuevoCodigo = null;
		
		try {
			nuevoCodigo = establecimientoServices.create(establecimiento);
		} catch(IllegalStateException e) {
			return ResponseEntity.badRequest().body(new RespuestaError(e.getMessage()));
		} catch(Exception e) {
			return ResponseEntity.internalServerError().body(new RespuestaError("Algo ha ido mal... Contacta con la empresa del backend"));
		}
		
		URI uri = ucb.path("/establecimientos/{codigo}").build(nuevoCodigo);
		
		return ResponseEntity.created(uri).build();
	}
}
