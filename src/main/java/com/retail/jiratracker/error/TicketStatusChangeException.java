package com.retail.jiratracker.error;

public class TicketStatusChangeException extends RuntimeException {
	
	public TicketStatusChangeException(final RuntimeException re) {
		super(re);
	}
}
