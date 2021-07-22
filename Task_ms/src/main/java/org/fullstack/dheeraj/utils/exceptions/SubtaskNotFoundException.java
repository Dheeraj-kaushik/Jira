package org.fullstack.dheeraj.utils.exceptions;

public class SubtaskNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public SubtaskNotFoundException() {
		message= "subtask not found";
	}
	
	public SubtaskNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "SubtaskNotFoundException [message=" + message + "]";
	}
	
	
	
	
}
