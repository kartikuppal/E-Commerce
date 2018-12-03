package com.infogain.app.service;

public class UserException extends Exception {
	String message;

	public String getMessage() {
		return message;
	}

	public UserException(String message) {
		super();
		this.message = message;
	}

}
