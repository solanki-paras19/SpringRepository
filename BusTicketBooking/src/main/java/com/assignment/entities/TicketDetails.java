package com.assignment.entities;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="ticket_details")
public class TicketDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	
	private int totalFare;
	@Column(length=50)
	private String pickUp;
	@Column(length=80)
	private String destination;
	@Column(length=10)
	private String totalSeats;
	@Column(length=50)
	private String seatNumbers;
	
	@ManyToOne
	@JoinColumn(name="user_ticket_fk")
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name="bus_ticket_fk")
	private BusDetails busDetails;

	@OneToMany
	private List<PassengerDetails> passenger;
	
	public TicketDetails() {
		super();
		
	}

	public TicketDetails(int ticketId, int totalFare, String pickUp, String destination, String totalSeats,
			String seatNumbers, UserDetails userDetails, BusDetails busDetails, List<PassengerDetails> passenger) {
		super();
		this.ticketId = ticketId;
		this.totalFare = totalFare;
		this.pickUp = pickUp;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.seatNumbers = seatNumbers;
		this.userDetails = userDetails;
		this.busDetails = busDetails;
		this.passenger = passenger;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
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

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}

	public List<PassengerDetails> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<PassengerDetails> passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", totalFare=" + totalFare + ", pickUp=" + pickUp
				+ ", destination=" + destination + ", totalSeats=" + totalSeats + ", seatNumbers=" + seatNumbers
				+ ", userDetails=" + userDetails + ", busDetails=" + busDetails + ", passenger=" + passenger + "]";
	}

			
		
}
