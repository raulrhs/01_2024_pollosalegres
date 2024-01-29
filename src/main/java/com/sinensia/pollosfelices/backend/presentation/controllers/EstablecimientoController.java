package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosfelices.backend.business.model.Establecimiento;
import com.sinensia.pollosfelices.backend.business.services.EstablecimientoServices;

@RestController
public class EstablecimientoController {

	@Autowired
	private EstablecimientoServices establecimientoServices;
	
	@GetMapping("/establecimientos")
	public List<Establecimiento> getAll(){
		return establecimientoServices.getAll();
	}
	
	@GetMapping("/establecimientos/{codigo}")
	public Establecimiento read(@PathVariable Long codigo) {
	
		// TODO 404
		
		Establecimiento establecimiento = establecimientoServices.read(codigo).orElse(null);
		
		return establecimiento;
	}
	
	@PostMapping("/establecimientos")
	public Establecimiento create(@RequestBody Establecimiento establecimiento) {
		
		Long nuevoCodigo = establecimientoServices.create(establecimiento);
		establecimiento.setCodigo(nuevoCodigo);
		
		return establecimiento;
	}
}
