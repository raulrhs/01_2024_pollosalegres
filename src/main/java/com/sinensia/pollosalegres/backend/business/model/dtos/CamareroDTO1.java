package com.sinensia.pollosalegres.backend.business.model.dtos;

import java.io.Serializable;

public class CamareroDTO1 implements Serializable{

	private Long id;
	private String nombreCompleto;
	private String licencia;
	
	public CamareroDTO1() {
		
	}
	
	public CamareroDTO1(Long id, String nombre, String apellido1, String apellido2, String licencia) {
		this.id = id;
		this.nombreCompleto = (apellido1 + " " + apellido2 + ", " + nombre).replace(" null", "");
		this.licencia = licencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

}
