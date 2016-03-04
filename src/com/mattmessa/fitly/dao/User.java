package com.mattmessa.fitly.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	@NotBlank(message="Username cannot be blank.")
	@Size(min=1, max=20, message="Username must be between 1 and 20 characters long.")
	private String username;
	
	@NotBlank
	@Pattern(regexp="^\\S+$")
	@Size(min=1, max=20, message="Password must be between 1 and 20 characters long.")
	private String password;
	
	@Email
	private String email;
	
	private boolean enabled = false;
	private String authority;
	
	public User(){
		
	}
	
	public User(int userId, String username, String password, boolean enabled, String authority, String email) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ email=" + email + ", password=" + password + "]";
	}

}
