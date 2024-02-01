package com.sinensia.pollosfelices.backend.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
@PrimaryKeyJoinColumn(name="CODIGO_CLIENTE")
public class Cliente extends Persona {

	@Column(name="GOLD")
	private boolean tarjetaGold;
	
	public Cliente() {
		// No args constructor
	}

	public boolean isTarjetaGold() {
		return tarjetaGold;
	}

	public void setTarjetaGold(boolean tarjetaGold) {
		this.tarjetaGold = tarjetaGold;
	}
	
}
