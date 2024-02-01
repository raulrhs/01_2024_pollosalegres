package com.sinensia.pollosalegres.backend.presentation.config;

import org.springframework.http.HttpStatus;

public class PresentationException extends RuntimeException {

	private final HttpStatus httpStatus;
	
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
