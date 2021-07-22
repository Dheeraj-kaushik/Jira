package org.fullstack.dheeraj.utils.exception;

public class DuplicateProjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public DuplicateProjectException() {
		message = "This project already exists";
	}
	
	public DuplicateProjectException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "DuplicateProjectException [message=" + message + "]";
	}
	
	
	
	
	
}
