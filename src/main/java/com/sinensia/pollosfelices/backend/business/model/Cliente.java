package com.sinensia.pollosfelices.backend.business.model;

public class Cliente extends Persona {

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
