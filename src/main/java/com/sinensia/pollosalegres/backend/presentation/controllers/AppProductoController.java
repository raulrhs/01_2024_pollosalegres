package com.sinensia.pollosalegres.backend.presentation.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.pollosalegres.backend.business.model.Producto;
import com.sinensia.pollosalegres.backend.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class AppProductoController {

	private ProductoServices productoServices;

	public AppProductoController(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}

	@GetMapping("/listado-productos")
	public ModelAndView getListaProductos(ModelAndView mav) {

		List<Producto> productos = productoServices.getAll();

		mav.setViewName("listado-productos");
		mav.addObject("productos", productos);

		return mav;
	}
}
