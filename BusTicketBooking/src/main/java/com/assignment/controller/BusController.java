package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entities.BusDetails;
import com.assignment.services.BusDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class BusController {

	@Autowired
	private BusDetailsServiceImpl busService;
	
	@PostMapping("/add/newBus")
	public BusDetails addNewBus(@RequestBody BusDetails busDetails)
	{
		BusDetails addedBus=busService.addBus(busDetails);
		return addedBus;
	}
}
