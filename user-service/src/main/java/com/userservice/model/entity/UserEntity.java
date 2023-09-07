package com.userservice.model.entity;

import java.util.List;

import com.userservice.model.enumeration.Role;
import com.userservice.model.enumeration.UsageType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class UserEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String email;
    @Enumerated(EnumType.STRING)
	private Role role;
    @Enumerated(EnumType.STRING)
	private UsageType usageType;
    private boolean activated;
	
	public UserEntity() {
		
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param role
	 * @param usageType
	 * @param activated
	 */
	public UserEntity(long id, String username, String password, String email, Role role, UsageType usageType, boolean activated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.usageType = usageType;
		this.activated = activated;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the usageType
	 */
	public UsageType getUsageType() {
		return usageType;
	}

	/**
	 * @param usageType the usageType to set
	 */
	public void setUsageType(UsageType usageType) {
		this.usageType = usageType;
	}
	

	public List<String> getAuthorities() {
		return List.of(role.name());
	}

	/**
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
}