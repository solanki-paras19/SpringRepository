package com.assignment.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusNotFoundException.class)
	 public ResponseEntity<ErrorDetails> busNotFoundException(BusNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
   }
  
	@ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<ErrorDetails> userNotFoundException(UserNotFoundException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
  }	
	
	@ExceptionHandler(TicketNotFoundException.class)
	 public ResponseEntity<ErrorDetails> ticketNotFoundException(TicketNotFoundException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
  }	
	
	@ExceptionHandler(PassengerNotFoundException.class)
	 public ResponseEntity<ErrorDetails> passengerNotFoundException(PassengerNotFoundException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
  }
	
   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
