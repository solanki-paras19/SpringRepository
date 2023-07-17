package com.assignment.dto;

import java.util.List;

import com.assignment.entities.Passenger;
public class TicketDTO {

	private int ticketFare;
	private String pickUp;
	private String destination;
	private String totalSeats;
	private String seatNumber;
	private String journeyDate;

	private String user;
	private List<Passenger> passenger;
	
	private String bus;

	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDTO(int ticketFare, String pickUp, String destination, String totalSeats, String seatNumber,
			String journeyDate, String user, List<Passenger> passenger, String bus) {
		super();
		this.ticketFare = ticketFare;
		this.pickUp = pickUp;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.seatNumber = seatNumber;
		this.journeyDate = journeyDate;
		this.user = user;
		this.passenger = passenger;
		this.bus = bus;
	}

	public int getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(int ticketFare) {
		this.ticketFare = ticketFare;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketFare=" + ticketFare + ", pickUp=" + pickUp + ", destination=" + destination
				+ ", totalSeats=" + totalSeats + ", seatNumber=" + seatNumber + ", journeyDate=" + journeyDate
				+ ", user=" + user + ", passenger=" + passenger + ", bus=" + bus + "]";
	}
	
	

}
