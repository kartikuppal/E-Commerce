/*package com.infogain.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
@ExceptionHandler(value =UserException.class)
public ResponseEntity<Object> userExceptionHandler(UserException userException)
{
return new ResponseEntity<>(userException.getMessage(),HttpStatus.IM_USED);
}
}*/