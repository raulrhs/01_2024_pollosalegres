package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.integration.repositories.CategoriaRepository;

@RestController
@RequestMapping("/pruebas")
public class BorrameController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
}
