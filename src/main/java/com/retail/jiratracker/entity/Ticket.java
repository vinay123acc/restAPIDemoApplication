package com.retail.jiratracker.entity;

import java.util.Date;

import com.retail.jiratracker.EnumTicketStatus;

public class Ticket {
	
	public String getTicketSummary() {
		return ticketSummary;
	}
	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}
	public String getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(String ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	private int ticketId;
	private String ticketSummary;
	private String ticketDetails;
	private EnumTicketStatus ticketStatus;
	private Date createdDate;
	private Date updatedDate;
	private Date assignedDate;
	private Date endDate;
	private String priority;
	private String targetRelease;
	private String assginedTo;
	
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public EnumTicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(EnumTicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTargetRelease() {
		return targetRelease;
	}
	public void setTargetRelease(String targetRelease) {
		this.targetRelease = targetRelease;
	}
	public String getAssginedTo() {
		return assginedTo;
	}
	public void setAssginedTo(String assginedTo) {
		this.assginedTo = assginedTo;
	}
	
	
}
