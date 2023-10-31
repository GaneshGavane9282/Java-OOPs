package com.tyss.schoolRegistration.exception;

public class StudentAlreadyAvailable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentAlreadyAvailable(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
}
