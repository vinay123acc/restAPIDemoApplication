package com.retail.jiratracker.error;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(final String errorMessage) {
		super(errorMessage);
	}

}
