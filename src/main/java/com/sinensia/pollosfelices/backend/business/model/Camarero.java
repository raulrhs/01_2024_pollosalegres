package com.sinensia.pollosfelices.backend.business.model;

public class Camarero extends Persona {

	private String licenciaManipuladorAlimentos;
	
	public Camarero() {
		// No args constructor
	}

	public String getLicenciaManipuladorAlimentos() {
		return licenciaManipuladorAlimentos;
	}

	public void setLicenciaManipuladorAlimentos(String licenciaManipuladorAlimentos) {
		this.licenciaManipuladorAlimentos = licenciaManipuladorAlimentos;
	}

}
