package com.assignment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.TicketDTO;
import com.assignment.entities.Bus;
import com.assignment.entities.Passenger;
import com.assignment.entities.Ticket;
import com.assignment.entities.User;
import com.assignment.repository.IBusRepository;
import com.assignment.repository.IPassengerRepository;
import com.assignment.repository.ITicketRepository;
import com.assignment.repository.IUserRepository;

@Service
public class TicketServiceImpl implements ITicketService {

	@Autowired
	private ITicketRepository ticketRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired 
	private BusServiceImpl busService;
	@Autowired
	private PassengerServiceImpl passengerService;
	@Autowired
	private IPassengerRepository passengerRepo;
	
	@Autowired
	private IBusRepository busRepo;
	
	@Override
	public Ticket generateTicket(TicketDTO ticketDto) {
	   Ticket ticket = new Ticket();
	   User user=userService.getUser(ticketDto.getUser()).get();
	   Bus bus=busService.getBusById(ticketDto.getBus()).get();
	  
	   
	    ticket.setTicketFare(ticketDto.getTicketFare());
		ticket.setPickUp(ticketDto.getPickUp());
		ticket.setDestination(ticketDto.getDestination());
		ticket.setTotalSeats(ticketDto.getTotalSeats());
		ticket.setSeatNumber(ticketDto.getSeatNumber());
		ticket.setJourneyDate(ticketDto.getJourneyDate());
		ticket.setBus(bus);
//		ticket.setPassenger(passenger);
		ticket.setUser(user);
	   Ticket tickets= ticketRepo.save(ticket);
	   List<Passenger> passenger=ticketDto.getPassenger();
	   for(Passenger p : passenger)
	   {
		   p.setTicket(tickets);
		  
	   }
	   tickets.setPassenger(passenger);
	   passengerRepo.saveAll(passenger);
	   return tickets;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Optional<Ticket> getTicketById(int ticketId) {
		return ticketRepo.findById(ticketId);
	}

	@Override
	public void deleteTicket(int ticketId) {
		ticketRepo.deleteById(ticketId);
		
	}

	@Override
	public Ticket updateTicket(int ticketId,TicketDTO ticketDto) {
		Ticket ticket = ticketRepo.findById(ticketId).get();
		   User user=userService.getUser(ticketDto.getUser()).get();
		   Bus bus=busService.getBusById(ticketDto.getBus()).get();
		   
		   
//		    List<Passenger> passenger = passengerRepo.findAllByTicket(ticketId);
//		    System.out.println(passenger);
//		   // List<Passenger> passenger = ticket.getPassenger();
//		   // System.out.println(passenger);
		   
		   ticket.setTicketFare(ticketDto.getTicketFare());
			ticket.setPickUp(ticketDto.getPickUp());
			ticket.setDestination(ticketDto.getDestination());
			ticket.setTotalSeats(ticketDto.getTotalSeats());
			ticket.setSeatNumber(ticketDto.getSeatNumber());
			ticket.setJourneyDate(ticketDto.getJourneyDate());
			ticket.setBus(bus);
			ticket.setUser(user);
           
			// ticket.setPassenger(passenger);
			
		    List<Passenger> passengers = ticketDto.getPassenger();
			List<Passenger> passenger=new ArrayList<Passenger>();
		     for(Passenger p: passengers)
		     {
		    	 Passenger pass = passengerRepo.findById(p.getPassengerId()).get();
		    	 pass.setAge(p.getAge());
		    	 pass.setGender(p.getGender());
		    	 pass.setName(p.getName());
		    	 pass.setTicket(ticket);
		    	 
		    	 passenger.add(pass);
		    	 
		     }
			ticket.setPassenger(passenger);
		   return ticketRepo.save(ticket);
		
	}

}
