package com.auth.exception;

public class WrongPasswordException extends RuntimeException{

	private static final long serialVersionUID = 4399122352459104937L;
	
	public WrongPasswordException(String message) {
		super(message);
	}

}
