package com.userservice.model.dto;

public class UserDtoForUpdate {
	
	
	private String username;
	private String email;
	
	
	public UserDtoForUpdate() {
		
	}


	/**
	 * @param username
	 * @param email
	 */
	public UserDtoForUpdate(String username,String email) {
		this.username = username;
		this.email = email;
	}


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


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


}
