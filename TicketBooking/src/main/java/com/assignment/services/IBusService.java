package com.assignment.services;

import java.util.List;
import java.util.Optional;

import com.assignment.entities.Bus;

public interface IBusService {

	public Bus addBus(Bus bus);
	public List<Bus> getAllBuses();
	public Optional<Bus> getBusById(String busId);
	public void deleteBus(String busId);
	public Bus updateBus(String busNumber,Bus bus);
}
