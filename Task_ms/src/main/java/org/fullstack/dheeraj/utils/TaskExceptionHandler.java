package org.fullstack.dheeraj.utils;

import org.fullstack.dheeraj.utils.exceptions.DuplicateTaskException;
import org.fullstack.dheeraj.utils.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler{

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
			DuplicateTaskException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(DuplicateTaskException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {
			TaskNotFoundException.class
	})
	public ResponseEntity<ExceptionMessage> handleAnyException(TaskNotFoundException exception , WebRequest request){
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getLocalizedMessage());
		return new ResponseEntity<ExceptionMessage>(exceptionMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
