package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosalegres.backend.business.model.Categoria;
import com.sinensia.pollosalegres.backend.business.model.Producto;
import com.sinensia.pollosalegres.backend.business.model.dtos.EstadisticaDTO1;
import com.sinensia.pollosalegres.backend.business.model.dtos.EstadisticaDTO2;
import com.sinensia.pollosalegres.backend.business.services.ProductoServices;
import com.sinensia.pollosalegres.backend.integration.model.CamareroPL;
import com.sinensia.pollosalegres.backend.integration.model.dtos.CamareroPLDTO1;
import com.sinensia.pollosalegres.backend.integration.repositories.CamareroPLRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pruebas")
public class BorrameController {

	@Autowired
	private CamareroPLRepository camareroPLRepository;
	
	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("14")
	public List<EstadisticaDTO2> prueba14(){
		return productoServices.getEstadisticasDTO2();
	}
	
	@GetMapping("13")
	public List<EstadisticaDTO1> prueba13(){
		return productoServices.getEstadisticasDTO1();
	}
	
	@GetMapping("12")
	public Map<String, Double> prueba12(){
		
		Map<Categoria, Double> resultado = productoServices.getEstadisticaPrecioMedioProductosPorCategoria();
		Map<String, Double> resultadoVO = new HashMap<>();
		
		for(Categoria categoria: resultado.keySet()) {
			System.out.println(categoria.getNombre() + ": " + resultado.get(categoria));
			resultadoVO.put(categoria.getNombre(), resultado.get(categoria));
		}
		
		return resultadoVO;
	}
	
	@GetMapping("11")
	public Map<String, Integer> prueba11(){
		
		Map<Categoria, Integer> resultado = productoServices.getEstadisticaNumeroProductoPorCategoria();
		Map<String, Integer> resultadoVO = new HashMap<>();
		
		for(Categoria categoria: resultado.keySet()) {
			resultadoVO.put(categoria.getNombre(), resultado.get(categoria));
		}
		
		return resultadoVO;
	}
	
	@GetMapping("10")
	public String prueba10() {
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		
		p1.setCodigo(100L);
		p2.setCodigo(101L);
		
		List<Producto> productos = Arrays.asList(p1, p2);
		
		productoServices.variarPrecio(productos, 10000.0);
		
		return "OK";
	}
	
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
