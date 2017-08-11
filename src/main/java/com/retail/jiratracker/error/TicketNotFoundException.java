package com.retail.jiratracker.error;

public class TicketNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TicketNotFoundException(final RuntimeException re) {
		super(re);
	}

}
