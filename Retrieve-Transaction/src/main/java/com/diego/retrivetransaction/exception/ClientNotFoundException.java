package com.diego.retrivetransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientNotFoundException extends RuntimeException {
	private String message;	
	private static final long serialVersionUID = 1L;
}
