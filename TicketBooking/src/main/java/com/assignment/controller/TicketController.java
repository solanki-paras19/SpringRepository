package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.TicketDTO;
import com.assignment.entities.Ticket;
import com.assignment.exception.TicketNotFoundException;
import com.assignment.services.TicketServiceImpl;


@RestController
@RequestMapping("/api")
public class TicketController {

	@Autowired 
	private TicketServiceImpl ticketService;
	
	@PostMapping("/generate/ticket")
	public Ticket generateTicket(@RequestBody TicketDTO ticketDto)
	{
		return ticketService.generateTicket(ticketDto);
	}
	
	@GetMapping("/getAll/tickets")
	public List<Ticket> getAllTickets()
	{
		return ticketService.getAllTickets();
	}
	
	@GetMapping("/get/ticketById/{ticketId}")
	public Ticket getTicketById(@PathVariable (value="ticketId") Integer ticketId)  throws TicketNotFoundException
	{
		Ticket ticket = ticketService.getTicketById(ticketId).orElseThrow(()->new TicketNotFoundException("No Ticket Available with Id "+ticketId));
	    return ticket;
	}
	
	@DeleteMapping("/delete/ticket/{ticketId}")
	public ResponseEntity<?> deleteTicket(@PathVariable(value="ticketId") Integer ticketId) throws TicketNotFoundException
	{   
		
		ticketService.getTicketById(ticketId).orElseThrow(()->new TicketNotFoundException("No Ticket Available with Id "+ticketId));
	    ticketService.deleteTicket(ticketId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/ticket/{ticketId}")
	public Ticket updateTicket(@PathVariable(value="ticketId") Integer ticketId,@RequestBody TicketDTO ticketDto) throws TicketNotFoundException
	{   
		ticketService.getTicketById(ticketId).orElseThrow(()->new TicketNotFoundException("No Ticket Available with Id "+ticketId));
		return ticketService.updateTicket(ticketId,ticketDto);
	}
}
