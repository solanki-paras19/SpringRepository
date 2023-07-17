package com.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entities.BusDetails;
import com.assignment.entities.PassengerDetails;
import com.assignment.entities.TicketDetails;
import com.assignment.entities.UserDetails;
import com.assignment.repository.IBusDetailsRepository;
import com.assignment.repository.ITicketDetailsRepository;
import com.assignment.repository.IUserDetailsRepository;
import com.assignment.repository.PassengerRepository;


@Service
public class TicketDetailsServiceImpl {

	@Autowired
	private ITicketDetailsRepository ticketRepo;
	
	@Autowired
	private IBusDetailsRepository busRepo;
	
	@Autowired
	private IUserDetailsRepository userRepo;
	
	@Autowired 
	private PassengerRepository passengerRepo;
	
	public TicketDetails generateTicket(TicketDetails ticketDetails)
	{   
		BusDetails bus = busRepo.save(ticketDetails.getBusDetails());
		
		UserDetails user =userRepo.save(ticketDetails.getUserDetails());
		List<PassengerDetails> passenger =ticketDetails.getPassenger();
		List<PassengerDetails> passenger2 = passengerRepo.saveAll(passenger);

	
		TicketDetails ticket =new TicketDetails();
		ticket.setBusDetails(bus);
		ticket.setUserDetails(user);
		ticket.setPassenger(passenger2);
		ticket= ticketRepo.save(ticketDetails);
		user.setTicket(ticketRepo.findAll());
		user.setPassenger(passenger2);
		return ticket;
	}
	
	public List<TicketDetails> getAllTickets()
	{
		return ticketRepo.findAll();
	}
	
	public void deleteTicketById(int ticketId)
	{
		ticketRepo.deleteById(ticketId);
	}
	
	public TicketDetails updateTicket(int ticketId,TicketDetails ticketDetails)
	{
		Optional<TicketDetails> ticket = ticketRepo.findById(ticketId);
		TicketDetails oldTicket= ticket.get();
		List<PassengerDetails> passenger = oldTicket.getPassenger();
		UserDetails user =oldTicket.getUserDetails();
		BusDetails bus = oldTicket.getBusDetails();
		oldTicket.setTotalFare(ticketDetails.getTotalFare());
		oldTicket.setPickUp(ticketDetails.getPickUp());
		oldTicket.setDestination(ticketDetails.getDestination());
		oldTicket.setSeatNumbers(ticketDetails.getSeatNumbers());
		oldTicket.setTotalSeats(ticketDetails.getTotalSeats());
		oldTicket.setBusDetails(bus);
		oldTicket.setPassenger(passenger);
		oldTicket.setUserDetails(user);
		ticketRepo.save(oldTicket);
		return oldTicket;
	}
}
