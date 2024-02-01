package com.sinensia.pollosalegres.backend.integration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMAREROS")
@PrimaryKeyJoinColumn(name="CODIGO_CAMARERO")
public class CamareroPL extends PersonaPL {

	private String licenciaManipuladorAlimentos;
	
	public CamareroPL() {
		// No args constructor
	}

	public String getLicenciaManipuladorAlimentos() {
		return licenciaManipuladorAlimentos;
	}

	public void setLicenciaManipuladorAlimentos(String licenciaManipuladorAlimentos) {
		this.licenciaManipuladorAlimentos = licenciaManipuladorAlimentos;
	}

}
