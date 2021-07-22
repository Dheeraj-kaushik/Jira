package org.fullstack.dheeraj.utils.exceptions;

public class DuplicateTaskException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public DuplicateTaskException() {
		message = "Task already exists";
	}
	
	public DuplicateTaskException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "DuplicateTaskException [message=" + message + "]";
	}
}
