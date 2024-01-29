package com.sinensia.pollosfelices.backend.presentation.config;

import java.io.Serializable;

public class RespuestaError implements Serializable{

	private String error;
	
	public RespuestaError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return "RespuestaError [error=" + error + "]";
	}
	
}
