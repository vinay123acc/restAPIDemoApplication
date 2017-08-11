package com.retail.jiratracker.dao;

import java.util.List;

import javax.inject.Named;

import com.retail.jiratracker.entity.Ticket;

@Named
public interface TicketRepository {
	
	List<Ticket> getAllTickets();
	List<Ticket> getAllTicketsPerRelease(String releaseId);
	String addNewTicket(Ticket ticket);
	String changeTicketStatus(int ticketId,String ticketStatus);
	String assignTicketToUser(int ticketId,String assignTo);
	void deleteRejectedTickets();
}
