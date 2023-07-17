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

import com.assignment.entities.TicketDetails;
import com.assignment.services.TicketDetailsServiceImpl;


@RestController
@RequestMapping("/api")
public class TicketController {

	@Autowired
	private TicketDetailsServiceImpl ticketService;
	
	@PostMapping("/generate/ticket")
	public TicketDetails generateTicket(@RequestBody TicketDetails ticketDetails)
	{
		System.out.print(ticketDetails.getBusDetails());
		return ticketService.generateTicket(ticketDetails);
	}
	
	@GetMapping("/getAll/tickets")
	public List<TicketDetails> getAllTickets()
	{
		return ticketService.getAllTickets();
	}
	
	@PutMapping("/update/ticket/{id}")
	public TicketDetails updateTicket(@PathVariable(value="id") Integer ticketId,@RequestBody TicketDetails ticketDetails)
	{
		
		return ticketService.updateTicket(ticketId,ticketDetails);
	}
	@DeleteMapping("/ticket/delete/{id}")
	public ResponseEntity<?> deleteTicket(@PathVariable(value="id") Integer ticketId)
	{   
		
			    ticketService.deleteTicketById(ticketId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
