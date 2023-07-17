package com.assignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passenger_details")
public class PassengerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int passengerId;
	@Column(length=60)
	private String name;
	@Column(length=20)
	private String age;
	@Column(length=20)
	private String gender;
	
	@ManyToOne
	@JoinColumn(name="user_passenger_fk")
	@JsonIgnore
	private UserDetails user;
	
	@ManyToOne
	@JoinColumn(name="ticket_passenger_fk")
    @JsonIgnore
	private TicketDetails ticket;
	
	public PassengerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassengerDetails(int passengerId, String name, String age, String gender, UserDetails user,
			TicketDetails ticket) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.user = user;
		this.ticket = ticket;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerId=" + passengerId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", user=" + user + ", ticket=" + ticket + "]";
	}
	
	
	
}
