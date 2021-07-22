package org.fullstack.dheeraj.utils.exceptions;

public class DuplicateSubtaskException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public DuplicateSubtaskException() {
		message = "duplicate already exists";
	}
	
	public DuplicateSubtaskException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "DuplicateSubtaskException [message=" + message + "]";
	}
	
	
	
	
}
