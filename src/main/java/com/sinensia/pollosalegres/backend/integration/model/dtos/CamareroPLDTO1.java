package com.sinensia.pollosalegres.backend.integration.model.dtos;

import java.io.Serializable;

public class CamareroPLDTO1 implements Serializable{

	private Long id;
	private String nombreCompleto;
	private String licencia;
	
	public CamareroPLDTO1(Long id, String nombre, String apellido1, String apellido2, String licencia) {
		this.id = id;
		this.nombreCompleto = (apellido1 + " " + apellido2 + ", " + nombre).replace(" null", "");
		this.licencia = licencia;
	}

	public Long getId() {
		return id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getLicencia() {
		return licencia;
	}

}
