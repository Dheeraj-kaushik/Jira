package org.fullstack.dheeraj.utils.exception;

public class DuplicateCompanyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public DuplicateCompanyException() {
		message = "This company already exists";
	}
	
	public DuplicateCompanyException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "DuplicateCompanyException [message=" + message + "]";
	}
}