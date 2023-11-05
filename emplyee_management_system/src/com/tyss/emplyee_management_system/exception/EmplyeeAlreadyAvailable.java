package com.tyss.emplyee_management_system.exception;

public class EmplyeeAlreadyAvailable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmplyeeAlreadyAvailable(String message) {
		super(message);
	}
}