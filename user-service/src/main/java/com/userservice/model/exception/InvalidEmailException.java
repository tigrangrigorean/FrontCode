package com.userservice.model.exception;

public class InvalidEmailException extends RuntimeException {

	private static final long serialVersionUID = -3069773281596200712L;
	
	public InvalidEmailException(String message) {
		super(message);
	}

}
