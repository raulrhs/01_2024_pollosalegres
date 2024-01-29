package com.sinensia.pollosfelices.backend.presentation.config;

import org.springframework.http.HttpStatus;

public class PresentationException extends RuntimeException {

	private HttpStatus httpStatus;
	
	public PresentationException(String mensaje, HttpStatus httpStatus) {
		super(mensaje);
		this.httpStatus = httpStatus;
	}
	
	public PresentationException(String mensaje, int statusCode) {
		super(mensaje);
		this.httpStatus = HttpStatus.valueOf(statusCode);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
