package com.infogain.app.exception;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	
	public String getMessage() {
		return message;
	}


	public CustomException(String message) {
		super(message);
	}
}
