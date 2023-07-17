package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entities.UserDetails;
import com.assignment.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userService;
	
	@PostMapping("/add/newUser")
	public UserDetails addUser(@RequestBody UserDetails userDetails)
	{
		return userService.addUser(userDetails);
	}
}
