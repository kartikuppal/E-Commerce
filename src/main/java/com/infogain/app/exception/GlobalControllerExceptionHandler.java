package com.infogain.app.exception;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infogain.app.util.ValidationUtil;

@ControllerAdvice
@RestController
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> handleInvalidInputException(InvalidInputException exception, 
			WebRequest request) {
		int statusCode = 400;
		
		ExceptionResponse error = new ExceptionResponse( LocalDateTime.now(), HttpStatus.valueOf(statusCode),
				"Validation Failed", "Unique Value Exception", exception.toString()); 
		
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		  }
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleAllException(final Exception exception, 
			final HttpServletRequest request) {
		int statusCode = 500;
		
		BindingResult result = ((MethodArgumentNotValidException) exception).getBindingResult();
		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.valueOf(statusCode));
		error.setError("Validation Failed");
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setErrors(ValidationUtil.fromBindingErrors(result));
		
		return error;
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		int statusCode = 400;
		BindingResult result = exception.getBindingResult();
		
		ExceptionResponse error = new ExceptionResponse(LocalDateTime.now(), HttpStatus.valueOf(statusCode), 
				"Validation Failed","Invalid Input",exception.getBindingResult().toString()); 
		error.setErrors(ValidationUtil.fromBindingErrors(result));
		
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		  }
}
