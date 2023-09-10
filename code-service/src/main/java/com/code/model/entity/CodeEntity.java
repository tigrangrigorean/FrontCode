package com.code.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "codes")
public class CodeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private UserEntity userEntity;
	private String title;
	private String snippet;
	private long likes;
	
	public CodeEntity() {
		
	}

	/**
	 * @param id
	 * @param userEntity
	 * @param title
	 * @param snippet
	 * @param likes
	 */
	public CodeEntity(long id, UserEntity userEntity, String title, String snippet, long likes) {
		super();
		this.id = id;
		this.userEntity = userEntity;
		this.title = title;
		this.snippet = snippet;
		this.likes = likes;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userEntity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * @param userEntity the userEntity to set
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * @return the title
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
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return the like
	 */
	public long getLike() {
		return likes;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(long like) {
		this.likes = like;
	}
}
