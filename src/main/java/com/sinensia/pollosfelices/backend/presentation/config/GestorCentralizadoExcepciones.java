package com.sinensia.pollosfelices.backend.presentation.config;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GestorCentralizadoExcepciones extends ResponseEntityExceptionHandler{

	// ***********************************************************************************************************
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request){
		RespuestaError respuestaError = new RespuestaError("Algo ha ido mal en el servidor...");
		return handleExceptionInternal(ex, respuestaError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	// ***********************************************************************************************************
	
	@ExceptionHandler(PresentationException.class)
	protected ResponseEntity<Object> handlePresentationException(PresentationException ex, WebRequest request){
		RespuestaError respuestaError = new RespuestaError(ex.getMessage());
		return handleExceptionInternal(ex, respuestaError, new HttpHeaders(), ex.getHttpStatus(), request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Object valorEntrante = ex.getValue();
		String tipoEntrante = valorEntrante != null ? valorEntrante.getClass().getName() : null;
		
		Class<?> requiredType = ex.getRequiredType();
		String nombreRequiredType = requiredType != null ? requiredType.getSimpleName() : null;
		
		RespuestaError respuestaError = new RespuestaError("El parámetro " + valorEntrante + " es de tipo " + tipoEntrante  + " - Se requiere un parámetro de tipo " + nombreRequiredType);
	
		return handleExceptionInternal(ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	// ***********************************************************************************************************
	
	
	
	
}
