package com.diego.retrivecurrenttransaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public ResponseEntity<ExceptionMessage> badRequest(HttpMessageNotReadableException ex, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage("Incorrect body", 400, request.getDescription(false) , ex.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { ClassNotFoundException.class })
	public ResponseEntity<ExceptionMessage> notFound(ClassNotFoundException ex, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage("Not found", 404, request.getDescription(false) , ex.getMessage());
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
}
