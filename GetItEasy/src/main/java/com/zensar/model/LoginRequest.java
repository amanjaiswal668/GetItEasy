package com.zensar.model;

public class LoginRequest {
	
	private String username;
	
	private String password;

	public LoginRequest() {
	}
	
	public LoginRequest(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [userName=" + username + ", password=" + password + "]";
	}
	

}
