package com.sinensia.pollosalegres.backend.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppPruebasController {

	@GetMapping("/pruebas")
	public String getPaginaPruebas() {
	
		return "pruebas";
	}
}
