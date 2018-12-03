package com.infogain.app.service;

public class UserException extends Exception{
	String message;
	
	
	
	public UserException(String message) {
		super();
		this.message = message;
	}



	@Override
	public String toString() {
		return "UserException [message=" + message + "]";
	}
	

}
