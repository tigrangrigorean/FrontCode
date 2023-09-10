package com.code.model.dto;

public class AddCodeDto {
	
	private String title;
	private String snippet;
	
	public AddCodeDto() {
		
	}

	/**
	 * @param title
	 * @param snippet
	 */
	public AddCodeDto(String title, String snippet) {
		super();
		this.title = title;
		this.snippet = snippet;
	}

	/**
	 * @return the snippet
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet the code to set
	 */
	public void setSnippet(String code) {
		this.snippet = code;
	}

}
