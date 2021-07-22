package org.fullstack.dheeraj.utils.exception;

public class ProjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public ProjectNotFoundException() {
		message = "Project not found";
	}
	
	public ProjectNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProjectNotFoundException [message=" + message + "]";
	}
	
	
	
	
	
	
}
