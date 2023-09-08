package com.userservice.model.dto;

public class PasswordDto {
	
	private String lastPassword;
	private String newPassword;
	private String repeatPassword;

	public PasswordDto() {
		
	}

	/**
	 * @param lastPassword
	 * @param newPassword
	 * @param repeatPassword
	 */
	public PasswordDto(String lastPassword, String newPassword, String repeatPassword) {
		super();
		this.lastPassword = lastPassword;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
	}

	/**
	 * @return the lastPassword
	 */
	public String getLastPassword() {
		return lastPassword;
	}

	/**
	 * @param lastPassword the lastPassword to set
	 */
	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the repeatPassword
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param repeatPassword the repeatPassword to set
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
}
