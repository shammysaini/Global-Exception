package com.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4460527516180612328L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

}

