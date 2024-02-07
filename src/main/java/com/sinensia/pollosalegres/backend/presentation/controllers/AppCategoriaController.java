package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.pollosalegres.backend.business.model.Categoria;
import com.sinensia.pollosalegres.backend.business.services.CategoriaServices;

@Controller
@RequestMapping("/app")
public class AppCategoriaController {

	private CategoriaServices categoriaServices;

	public AppCategoriaController(CategoriaServices categoriaServices) {
		this.categoriaServices = categoriaServices;
	}

	@GetMapping("/listado-categorias")
	public ModelAndView getListaCategorias(ModelAndView mav) {

		List<Categoria> categorias = categoriaServices.getAll();

		mav.setViewName("listado-categorias");
		mav.addObject("categorias", categorias);

		return mav;
	}
}
