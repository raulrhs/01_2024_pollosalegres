package com.sinensia.pollosfelices.backend.business.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LineaPedido implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="CODIGO_PRODUCTO")
	private Producto producto;
	
	private int cantidad;
	
	public LineaPedido() {
		// No args constructor
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
