package com.apigateway.service;

import org.springframework.stereotype.Component;

@Component
public class GetUsername {
	
	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	


}
