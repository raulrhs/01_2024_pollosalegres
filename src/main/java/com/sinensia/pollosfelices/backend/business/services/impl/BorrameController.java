package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosfelices.backend.business.model.dtos.EstadisticaDTO1;
import com.sinensia.pollosfelices.backend.business.services.ProductoServices;

@RestController
@RequestMapping("/pruebas")
public class BorrameController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/estadisticasdto1")
	public List<EstadisticaDTO1> getEstadisticasDTO1(){
		return productoServices.getEstadisticasDTO1();
	}
}
