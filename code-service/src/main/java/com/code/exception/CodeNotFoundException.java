package com.code.exception;

public class CodeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7231902882457521057L;
	
	public CodeNotFoundException(String message) {
		super(message);
	}

}
