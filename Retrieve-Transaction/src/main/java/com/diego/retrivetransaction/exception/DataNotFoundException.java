package com.diego.retrivetransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataNotFoundException extends ClassNotFoundException {
	private static final long serialVersionUID = 1L;
	private String message;	

}
