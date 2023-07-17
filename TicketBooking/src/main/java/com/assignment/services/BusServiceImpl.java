package com.assignment.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entities.Bus;
import com.assignment.repository.IBusRepository;

@Service
public class BusServiceImpl implements IBusService  {

	@Autowired
	private IBusRepository busRepo;
	
	@Override
	public Bus addBus(Bus bus) {
		return busRepo.save(bus);
	}

	@Override
	public List<Bus> getAllBuses() {
	
		return busRepo.findAll();
	}

	@Override
	public Optional<Bus> getBusById(String busId) {
		Optional<Bus> bus =busRepo.findById(busId);
		return bus;
	}

	@Override
	public void deleteBus(String busId) {
		busRepo.deleteById(busId);
		
	}

	@Override
	public Bus updateBus(String busNumber, Bus bus) {
		Bus newbus = busRepo.findById(busNumber).get();
		newbus.setBusName(bus.getBusName());
		newbus.setBusType(bus.getBusType());
		newbus.setNoOfSeats(bus.getNoOfSeats());
		return busRepo.save(newbus);
	}

}
