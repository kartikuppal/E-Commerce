package com.infogain.app.exception;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
	private Integer code;
	private String message;
	
	public CustomException() {
		super();
	}
	
	public CustomException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public CustomException(String message) {
		super();
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
=======

	public CustomException(String message) {
		super(message);
>>>>>>> 7dd7faed42c06206121171f492f4016151683369
	}
}
