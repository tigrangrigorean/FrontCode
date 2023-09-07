package com.userservice.model.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7557550081303658154L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
