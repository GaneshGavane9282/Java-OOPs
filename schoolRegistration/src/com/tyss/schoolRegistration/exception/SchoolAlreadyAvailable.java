package com.tyss.schoolRegistration.exception;

public class SchoolAlreadyAvailable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SchoolAlreadyAvailable(String message) {
		super(message);
	}
	
}
