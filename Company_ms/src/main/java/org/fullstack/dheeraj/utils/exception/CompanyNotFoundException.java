package org.fullstack.dheeraj.utils.exception;

public class CompanyNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public CompanyNotFoundException() {
		message = "Company not found in the database";
	}
	
	public CompanyNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "CompanyNotFoundException [message=" + message + "]";
	}
	
}
