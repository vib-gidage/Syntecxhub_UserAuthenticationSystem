package com.project.UserOperationsManagement.DTO;

public class AuthResponce {
	
	private String token;

	public AuthResponce() {
	}

	public AuthResponce(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
