package com.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entities.User;
import com.assignment.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	@Override
	public User addUser(User user) {
	
		return  userRepo.save(user);
		
	}

	@Override
	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
		
	}

	@Override
	public Optional<User> getUser(String userId) {
		Optional<User> user=userRepo.findById(userId);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}
	@Override
	public User updateUser(String userId,User user)
	{
		User usr = userRepo.findById(userId).get();
		usr.setPassword(user.getPassword());
		return userRepo.save(usr);
	}

}
