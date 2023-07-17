package com.assignment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bus_data")
public class Bus {

	@Id
	@Column(length=20)
	private String busNumber;
	
	@Column(length=20)
	private String busType;
	
	@Column(length=20)
	private String busName;
	
	@Column(length=20)
	private String noOfSeats;
	
	@OneToMany(mappedBy="bus")
	@JsonIgnore
	private List<Ticket> tickets;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String busNumber, String busType, String busName, String noOfSeats, List<Ticket> tickets) {
		super();
		this.busNumber = busNumber;
		this.busType = busType;
		this.busName = busName;
		this.noOfSeats = noOfSeats;
		this.tickets = tickets;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Bus [busNumber=" + busNumber + ", busType=" + busType + ", busName=" + busName + ", noOfSeats="
				+ noOfSeats + ", tickets=" + tickets + "]";
	}

		
	
}
