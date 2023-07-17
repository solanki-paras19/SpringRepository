package com.assignment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bus_details")
public class BusDetails {

	@Id
	@Column(length=11)
	private String busNumber;
	@Column(length=11)
	private String busType;
	@Column(length=50)
	private String busName;
	@Column(length=2)
	private int noOfSeats;
	
	@OneToMany(mappedBy="busDetails",cascade= {CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JsonIgnore
	private List<TicketDetails> ticket;

	public BusDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusDetails(String busNumber, String busType, String busName, int noOfSeats, List<TicketDetails> ticket) {
		super();
		this.busNumber = busNumber;
		this.busType = busType;
		this.busName = busName;
		this.noOfSeats = noOfSeats;
		this.ticket = ticket;
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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<TicketDetails> getTicket() {
		return ticket;
	}

	public void setTicket(List<TicketDetails> ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "BusDetails [busNumber=" + busNumber + ", busType=" + busType + ", busName=" + busName + ", noOfSeats="
				+ noOfSeats + ", ticket=" + ticket + "]";
	}
	
	
}
