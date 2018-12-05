package com.infogain.app.exception;

public class CustomException extends Exception {
	String message;

	
	public String getMessage() {
		return message;
	}


	public CustomException(String message) {
		super();
		this.message = message;
	}
	

}
