package com.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BusNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public BusNotFoundException(String message) {
	    super(message);
		
	}

}
