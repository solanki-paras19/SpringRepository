package com.assignment.services;

import java.util.List;

import com.assignment.entities.TicketDetails;

public interface ITicketDetailsService {

	public TicketDetails generateTicket(TicketDetails ticketDetails);
	public List<TicketDetails> getAllTickets();
	public void deleteTicketById(int ticketId);
	public TicketDetails updateTicket(int ticketId,TicketDetails ticketDetails);
	
}
