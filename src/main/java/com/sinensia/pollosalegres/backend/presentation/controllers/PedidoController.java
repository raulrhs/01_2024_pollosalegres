package com.sinensia.pollosalegres.backend.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.pollosalegres.backend.business.services.PedidoServices;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoServices pedidoServices;
	
	public PedidoController(PedidoServices pedidoServices) {
		this.pedidoServices = pedidoServices;
	}
	
	
	
}
