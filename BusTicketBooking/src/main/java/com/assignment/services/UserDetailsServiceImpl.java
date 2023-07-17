package com.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entities.UserDetails;
import com.assignment.repository.IUserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService{

	@Autowired
	private IUserDetailsRepository userRepo;
	
	@Override
	public UserDetails addUser(UserDetails userDetails) {
		
		return userRepo.save(userDetails);
	}

}
