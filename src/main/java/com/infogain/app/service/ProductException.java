package com.infogain.app.service;

public class ProductException extends Exception {
	private String message;

	public ProductException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
