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

import com.assignment.entities.User;
import com.assignment.exception.BusNotFoundException;
import com.assignment.exception.TicketNotFoundException;
import com.assignment.exception.UserNotFoundException;
import com.assignment.services.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/add/newuser")
	public User addUser(@RequestBody User user) 
	{
	
		return userService.addUser(user);
	}
	
	@GetMapping("/getAll/users")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/get/userById/{userId}")
	public User getUserById(@PathVariable (value="userId") String userId) throws UserNotFoundException
	{
		User user =userService.getUser(userId).orElseThrow(()->new UserNotFoundException("No User found with this id: "+userId));
	    return user;
	}
	
	@PutMapping("update/user/{userId}")
	public User updateUser(@PathVariable("userId") String userId,@RequestBody User user) throws UserNotFoundException
	{
	       	userService.getUser(userId).orElseThrow(()-> new UserNotFoundException("User Not Available with Id "+userId));
	       	return userService.updateUser(userId,user);
	}
	@DeleteMapping("/delete/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="userId") String userId) throws UserNotFoundException
	{   
		
		userService.getUser(userId).orElseThrow(()->new UserNotFoundException("No User Available with Id "+userId));
	    userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
