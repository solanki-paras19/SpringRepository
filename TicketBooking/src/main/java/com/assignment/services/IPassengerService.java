package com.assignment.services;

import java.util.List;

import com.assignment.entities.Passenger;

public interface IPassengerService {

	public List<Passenger> updatePassenger(int ticketId,List<Passenger> passeneger);
}
