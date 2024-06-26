package com.personal.spring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.personal.spring.services.exceptions.DatabaseException;
import com.personal.spring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException rnfe, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError errorFields = new StandardError(Instant.now(), status.value(), error, rnfe.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorFields);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseBadRequest(DatabaseException dbe, HttpServletRequest request){
		String error = "Database retrieval error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError errorFields = new StandardError(Instant.now(), status.value(), error, dbe.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorFields);
	}
	
	
}
