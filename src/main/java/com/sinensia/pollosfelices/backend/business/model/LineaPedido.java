package com.sinensia.pollosfelices.backend.business.model;

import java.io.Serializable;

public class LineaPedido implements Serializable {
	
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
