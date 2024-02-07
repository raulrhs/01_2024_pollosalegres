package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.pollosalegres.backend.business.model.Establecimiento;
import com.sinensia.pollosalegres.backend.business.services.EstablecimientoServices;

@Controller
@RequestMapping("/app")
public class AppEstablecimientoController {

	private EstablecimientoServices establecimientoServices;

	public AppEstablecimientoController(EstablecimientoServices establecimientoServices) {
		this.establecimientoServices = establecimientoServices;
	}

	@GetMapping("/listado-establecimientos")
	public ModelAndView getListaEstablecimientos(ModelAndView mav) {

		List<Establecimiento> establecimientos = establecimientoServices.getAll();

		mav.setViewName("listado-establecimientos");
		mav.addObject("establecimientos", establecimientos);

		return mav;
	}
}
