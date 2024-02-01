package com.sinensia.pollosfelices.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosfelices.backend.business.model.Camarero;
import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.model.Cliente;
import com.sinensia.pollosfelices.backend.business.model.Establecimiento;
import com.sinensia.pollosfelices.backend.business.model.Pedido;
import com.sinensia.pollosfelices.backend.business.model.Persona;
import com.sinensia.pollosfelices.backend.business.model.Producto;
import com.sinensia.pollosfelices.backend.integration.repositories.CamareroRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.CategoriaRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.ClienteRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.EstablecimientoRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.PedidoRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.PersonaRepository;
import com.sinensia.pollosfelices.backend.integration.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pruebas")
public class BorrameController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private CamareroRepository camareroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/pedidos")
	@Transactional
	public List<Pedido> getPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/camareros")
	public List<Camarero> getCamareros(){
		return camareroRepository.findAll();
	}
	
	@GetMapping("/personas")
	public List<Persona> getPersonas(){
		return personaRepository.findAll();
	}
	
	
	@GetMapping("/productos")
	public List<Producto> getProductoss(){
		return productoRepository.findAll();
	}
	
	@GetMapping("/establecimientos")
	public List<Establecimiento> getEstablecimientos(){
		return establecimientoRepository.findAll();
	}
	
	@GetMapping("/categorias")
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
}
