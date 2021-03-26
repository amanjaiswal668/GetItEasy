package com.zensar.model;

public class LoginResponse {

	private String token;

	private String type;

	private String name;

	public LoginResponse() {
	}

	

	public LoginResponse(String token, String type, String name) {
		super();
		this.token = token;
		this.type = type;
		this.name = name;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", type=" + type + ", name=" + name + "]";
	}

	
	
}
