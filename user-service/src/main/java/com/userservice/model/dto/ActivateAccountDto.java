package com.userservice.model.dto;

public class ActivateAccountDto {
	
	private String email;
	private String code;
	
	public ActivateAccountDto() {
		
	}

	/**
	 * @param email
	 * @param code
	 */
	public ActivateAccountDto(String email, String code) {
		super();
		this.email = email;
		this.code = code;
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

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
