package com.tbs.exception;

public class TicketException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketException() {
		
	}
	
	public TicketException(String message){
		super(message);
	}

	
}
