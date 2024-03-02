package com.tbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = TicketException.class)
	public ResponseEntity<ExceptionBean> handleTicketException(TicketException te){
		String message = te.getMessage();
		ExceptionBean eb = new ExceptionBean();
		eb.setMessage(message);
		eb.setCode("TCXNF404");
		return new ResponseEntity<>(eb,HttpStatus.BAD_REQUEST);
	}

}
