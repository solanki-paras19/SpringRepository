package com.assignment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users_data")
public class User {

	@Id
	@Column(length=13)
	private String mobileNumber;
	@Column(length=60)
	private String password;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Ticket> tickets;

	public User() {
		super();
	}

	public User(String mobileNumber, String password, List<Ticket> tickets) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.tickets = tickets;
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "User [mobileNumber=" + mobileNumber + ", password=" + password + ", tickets=" + tickets + "]";
	}
	
	
	
	
}
