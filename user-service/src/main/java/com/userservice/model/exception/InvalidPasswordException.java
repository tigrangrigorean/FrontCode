package com.userservice.model.exception;

public class InvalidPasswordException extends RuntimeException{


	private static final long serialVersionUID = -8196653134534011708L;
	
	public InvalidPasswordException(String message) {
		super(message);
	}

}
