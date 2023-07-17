package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entities.Bus;
import com.assignment.entities.User;
import com.assignment.exception.BusNotFoundException;
import com.assignment.exception.UserNotFoundException;
import com.assignment.services.BusServiceImpl;

@RestController
@RequestMapping("/api")
public class BusController {

	@Autowired
	private BusServiceImpl busService;
	
	@PostMapping("/add/newBus")
	public Bus addNewBus(@RequestBody Bus bus)
	{
		return busService.addBus(bus);
	}
	
	@GetMapping("/getAll/buses")
	public List<Bus> getAllBuses()
	{
		return busService.getAllBuses();
	}
  
	@GetMapping("/get/busById/{busId}")
	public ResponseEntity<Bus> getBusById(@PathVariable (value="busId") String busId) throws BusNotFoundException 
	{
		Bus bus = busService.getBusById(busId).orElseThrow(()->new BusNotFoundException("No Bus found with this id: "+busId));
	     return ResponseEntity.ok().body(bus);
	}
	
	@PutMapping("update/bus/{busNumber}")
	public Bus updateBus(@PathVariable("busNumber") String busNumber,@RequestBody Bus bus) throws BusNotFoundException
	{
	       	busService.getBusById(busNumber).orElseThrow(()-> new BusNotFoundException("Bus Not Available with Bus Number "+busNumber));
	       	return busService.updateBus(busNumber,bus);
	}
	@DeleteMapping("/delete/bus/{busNumber}")
	public ResponseEntity<?> deleteBus(@PathVariable(value="busNumber") String busNumber) throws BusNotFoundException
	{   
		
		busService.getBusById(busNumber).orElseThrow(()-> new BusNotFoundException("Bus Not Available with Bus Number "+busNumber));
	    busService.deleteBus(busNumber);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
