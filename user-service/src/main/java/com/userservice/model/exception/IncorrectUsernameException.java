package com.userservice.model.exception;

public class IncorrectUsernameException extends RuntimeException{

	private static final long serialVersionUID = -2383031165391110426L;

	public IncorrectUsernameException(String message) {
		super(message);
	}
	
}
