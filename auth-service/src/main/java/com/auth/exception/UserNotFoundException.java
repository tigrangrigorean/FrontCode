package com.auth.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8315552626592002530L;
	
	
	public UserNotFoundException(String message) {
		super(message);
	}
	

}
