package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.pollosalegres.backend.business.model.Camarero;
import com.sinensia.pollosalegres.backend.business.services.CamareroServices;

@Controller
@RequestMapping("/app")
public class AppCamareroController {

	private CamareroServices camareroServices;
	
	public AppCamareroController(CamareroServices camareroServices) {
		this.camareroServices = camareroServices;
	}
	
	@GetMapping("/listado-camareros")
	public ModelAndView getListaCamareros(ModelAndView mav) {
		
		List<Camarero> camareros = camareroServices.getAll();
		
		mav.setViewName("listado-camareros");
		mav.addObject("camareros", camareros);
		
		return mav;
	}
}
