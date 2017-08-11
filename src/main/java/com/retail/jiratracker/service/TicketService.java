package com.retail.jiratracker.service;

import java.util.List;

import javax.inject.Named;

import com.retail.jiratracker.entity.Ticket;

@Named
public interface TicketService {
	
	public List<Ticket> getAllTickets();
	List<Ticket> getAllTicketsPerRelease(String releaseId);
	String addNewTicket(Ticket ticket);
	String changeTicketStatus(int ticketId,String ticketStatus);
	String assignTicketToUser(int ticketId,String assignTo);
	void deleteRejectedTickets();
}
