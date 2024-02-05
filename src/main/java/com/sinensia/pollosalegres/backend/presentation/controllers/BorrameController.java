package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosalegres.backend.integration.model.CamareroPL;
import com.sinensia.pollosalegres.backend.integration.model.dtos.CamareroPLDTO1;
import com.sinensia.pollosalegres.backend.integration.repositories.CamareroPLRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pruebas")
public class BorrameController {

	@Autowired
	private CamareroPLRepository camareroPLRepository;
	
	@GetMapping("/9")
	@Transactional
	public String prueba9(){
		
		camareroPLRepository.mayusculizarNombres();
		
		return "nombres mayusculizados";
	}
	
	@GetMapping("/8")
	public List<Object[]> prueba8(){
		return camareroPLRepository.getTabla4();
	}
	
	@GetMapping("/7")
	public List<CamareroPLDTO1> prueba7(){
		return camareroPLRepository.findAllDTO1();
	}
	
	@GetMapping("/6")
	public List<Object[]> prueba6(){
		return camareroPLRepository.getTabla3();
	}
	
	@GetMapping("/5")
	public List<Object[]> prueba5(){
		return camareroPLRepository.getTabla2();
	}
	
	@GetMapping("/4")
	public List<Object[]> prueba4(){
		return camareroPLRepository.getTabla1();
	}

	@GetMapping("/3")
	public List<CamareroPL> prueba3(){
		return camareroPLRepository.getApellido1Largo(8);
	}
	
	@GetMapping("/2")
	public List<CamareroPL> prueba2(){
		return camareroPLRepository.getApellido2Null();
	}
	
	@GetMapping("/1")
	public List<CamareroPL> prueba1(){
		return camareroPLRepository.getAll();
	}
	
}
