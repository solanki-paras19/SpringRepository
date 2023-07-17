package com.assignment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets_data")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	@Column(length=2)
	private int ticketFare;
	@Column(length=60)
	private String pickUp;
	@Column(length=60)
	private String destination;
	@Column(length=60)
	private String totalSeats;
	@Column(length=50)
	private String seatNumber;
	@Column(length=18)
	private String journeyDate;
	
	@ManyToOne
	@JoinColumn(name="user_ticket_fk")
//	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="ticket",cascade=CascadeType.ALL)
	private List<Passenger> passenger;
	
	@ManyToOne
	@JoinColumn(name="bus_ticket_fk")
//	@JsonIgnore
	private Bus bus;

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, int ticketFare, String pickUp, String destination, String totalSeats, String seatNumber,
			String journeyDate, User user, List<Passenger> passenger, Bus bus) {
		super();
		this.ticketId = ticketId;
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

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketFare=" + ticketFare + ", pickUp=" + pickUp + ", destination="
				+ destination + ", totalSeats=" + totalSeats + ", seatNumber=" + seatNumber + ", journeyDate="
				+ journeyDate + ", user=" + user + ", passenger=" + passenger + ", bus=" + bus + "]";
	}
	
	
	
	
	
	
}
