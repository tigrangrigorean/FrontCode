package com.code.exception;

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 2218014035917327198L;
	
	public AccessDeniedException(String message) {
		super(message);
	}

}
