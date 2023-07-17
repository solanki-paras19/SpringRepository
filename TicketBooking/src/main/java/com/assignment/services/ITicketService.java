package com.assignment.services;

import java.util.List;
import java.util.Optional;

import com.assignment.dto.TicketDTO;
import com.assignment.entities.Ticket;

public interface ITicketService {
 
	public Ticket generateTicket(TicketDTO ticketDTO);
	public List<Ticket> getAllTickets();
	public Optional<Ticket> getTicketById(int ticketId);
	public void deleteTicket(int ticketId);
	public Ticket updateTicket(int ticketId,TicketDTO ticketDto);
}
