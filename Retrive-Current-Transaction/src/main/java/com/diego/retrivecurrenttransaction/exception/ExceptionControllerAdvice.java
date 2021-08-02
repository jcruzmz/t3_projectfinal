package com.diego.retrivecurrenttransaction.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ExceptionMessage> badRequest(Exception ex, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage("Internal Server Error", 500, request.getDescription(false),
				ex.getMessage());
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { ClassNotFoundException.class })
	public ResponseEntity<ExceptionMessage> notFound(ClassNotFoundException ex, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage("Not found", 404, request.getDescription(false),
				ex.getMessage());
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionMessage> validationBody(MethodArgumentNotValidException ex, WebRequest request) {
		HashMap<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		ExceptionMessage message = new ExceptionMessage("Incorrect body", 400, request.getDescription(false),
				errors.toString());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
