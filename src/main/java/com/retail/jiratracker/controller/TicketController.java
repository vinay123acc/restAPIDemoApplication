package com.retail.jiratracker.controller;


import static com.retail.jiratracker.JiraTrackerQueryConstants.APPLICATION_JSON_TYPE;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.jiratracker.entity.Ticket;
import com.retail.jiratracker.error.ResourceNotFoundException;
import com.retail.jiratracker.service.TicketService;

@Named
@Path("/tickets")
@Produces(APPLICATION_JSON_TYPE)
@Consumes(APPLICATION_JSON_TYPE)
public class TicketController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);
	
	@Inject
	private TicketService ticketService;
	
	@GET
	public Response getAllTickets(){
		  LOGGER.info("Entering getAllTickets");
		List<Ticket> tickets = ticketService.getAllTickets();
		return Response.ok(tickets).build();
	}
	
	@GET
	@Path("/release")
	public Response getAllTicketsPerRelease(@QueryParam("releaseId") String releaseId){
		LOGGER.info("Entering getAllTicketsPerRelease: ",releaseId);
		
		if(!(Optional.ofNullable(releaseId).isPresent() && !releaseId.isEmpty())){
			throw new ResourceNotFoundException("Query Parameter is Required");
		}
		List<Ticket> tickets = ticketService.getAllTicketsPerRelease(releaseId);
		return Response.ok(tickets).build();
		
	}
	
	@POST
	@Path("/newTicket")
	public Response addNewTicket(Ticket ticket){
		LOGGER.info("Entering addNewTicket: ",ticket.getTicketSummary());
		
		if(!(Optional.ofNullable(ticket.getTicketSummary()).isPresent() && !ticket.getTicketSummary().isEmpty())){
			throw new ResourceNotFoundException("Query Parameter is Required");
		}
		
		String ticketId =ticketService.addNewTicket(ticket);
		return Response.ok(ticketId).build();
	}
	
	@PUT
	@Path("/status")
	public Response changeTicketStatus(@QueryParam("ticketId") int ticketId,@QueryParam("ticketStatus") String ticketStatus){
		LOGGER.info("Entering changeTicketStatus: ",ticketId +" "+ticketStatus);
		
		if(!(Optional.ofNullable(ticketId).isPresent() && ticketId>0 
				&& Optional.ofNullable(ticketStatus).isPresent() && !ticketStatus.isEmpty())){
			throw new ResourceNotFoundException("Query Parameter is Required");
		}
		
		String tkctId=ticketService.changeTicketStatus(ticketId, ticketStatus);
		return Response.ok(tkctId).build();
	}
	
	@PUT
	@Path("/assign")
	public Response assignTicketToUser(@QueryParam("ticketId") int ticketId,@QueryParam("assignTo") String assignTo){
		
		LOGGER.info("Entering assignTicketToUser: ",ticketId +" "+assignTo);
		
		if(!(Optional.ofNullable(ticketId).isPresent() && ticketId>0 
				&& Optional.ofNullable(assignTo).isPresent() && !assignTo.isEmpty())){
			throw new ResourceNotFoundException("Query Parameter is Required");
		}
		
		String tcktId=ticketService.assignTicketToUser(ticketId, assignTo);
		return Response.ok(tcktId).build();
	}
	
	@DELETE
	@Path("/remove")
	public Response deleteRejectedTickets(){
		
		LOGGER.info("Entering deleteRejectedTickets: ");
		
		ticketService.deleteRejectedTickets();
		
		return Response.ok().build();
		
	}
	
	
}
