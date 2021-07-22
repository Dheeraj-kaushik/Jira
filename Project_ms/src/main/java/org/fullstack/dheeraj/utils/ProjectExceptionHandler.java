package org.fullstack.dheeraj.utils;

import org.fullstack.dheeraj.utils.exception.DuplicateProjectException;
import org.fullstack.dheeraj.utils.exception.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler{

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
	
	@ExceptionHandler(value= {
			DuplicateProjectException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(DuplicateProjectException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {
			ProjectNotFoundException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(ProjectNotFoundException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
}
