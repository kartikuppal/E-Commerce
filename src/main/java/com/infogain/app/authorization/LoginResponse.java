package com.infogain.app.authorization;

public class LoginResponse {
	private String token;
	private String status;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoginResponse() {
		
	}
	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", status=" + status + "]";
	}
	
	
	

}
