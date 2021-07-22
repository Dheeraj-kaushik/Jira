package org.fullstack.dheeraj.utils.exceptions;

public class TaskNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public TaskNotFoundException() {
		message = "Task does not exist in the db";
	}
	
	public TaskNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "TaskNotFoundException [message=" + message + "]";
	}
	
	
	
	
	
	
}
