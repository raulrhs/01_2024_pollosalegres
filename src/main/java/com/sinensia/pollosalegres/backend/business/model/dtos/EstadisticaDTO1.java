package com.sinensia.pollosalegres.backend.business.model.dtos;

import java.io.Serializable;

public class EstadisticaDTO1 implements Serializable {

	private Long id;
	private String nombreCategoria;
	private int cantidad;
	
	public EstadisticaDTO1(Long id, String nombreCategoria, int cantidad) {
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public int getCantidad() {
		return cantidad;
	}
}
