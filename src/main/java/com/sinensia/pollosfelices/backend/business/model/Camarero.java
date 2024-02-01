package com.sinensia.pollosfelices.backend.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMAREROS")
@PrimaryKeyJoinColumn(name="CODIGO_CAMARERO")
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
