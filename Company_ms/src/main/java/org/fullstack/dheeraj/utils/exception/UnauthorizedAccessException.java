package org.fullstack.dheeraj.utils.exception;

public class UnauthorizedAccessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public UnauthorizedAccessException() {
		message = "You are not authorised to access this";
	}
	
	public UnauthorizedAccessException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "UnauthorizedAccessException [message=" + message + "]";
	}
}
