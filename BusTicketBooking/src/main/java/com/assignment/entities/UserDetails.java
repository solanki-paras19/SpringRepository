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
@Table(name="user_details")
public class UserDetails {

	@Id
	private String mobileNumber;
	@Column(length=60)
    private String password;
	
	@OneToMany
	@JsonIgnore
	private List<TicketDetails> ticket;
	
	@OneToMany
	@JsonIgnore
	private List<PassengerDetails> passenger;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String mobileNumber, String password, List<TicketDetails> ticket,
			List<PassengerDetails> passenger) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.ticket = ticket;
		this.passenger = passenger;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TicketDetails> getTicket() {
		return ticket;
	}

	public void setTicket(List<TicketDetails> ticket) {
		this.ticket = ticket;
	}

	public List<PassengerDetails> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<PassengerDetails> passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "UserDetails [mobileNumber=" + mobileNumber + ", password=" + password + ", ticket=" + ticket
				+ ", passenger=" + passenger + "]";
	}

  
   
		
}
