package org.fullstack.dheeraj.utils;

import org.fullstack.dheeraj.utils.exception.CompanyNotFoundException;
import org.fullstack.dheeraj.utils.exception.DuplicateCompanyException;
import org.fullstack.dheeraj.utils.exception.UnauthorizedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CompanyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {
			Exception.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(Exception exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {
			NullPointerException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(NullPointerException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {
			CompanyNotFoundException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(CompanyNotFoundException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {
			DuplicateCompanyException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(DuplicateCompanyException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {
			UnauthorizedAccessException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(UnauthorizedAccessException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.BAD_REQUEST);
	}
	
	
	
	

}
