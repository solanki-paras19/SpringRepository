package com.assignment.services;

import java.util.List;
import java.util.Optional;

import com.assignment.entities.User;

public interface IUserService {

	public User addUser(User user);
	public void deleteUser(String userId);
	public Optional<User> getUser(String userId);
	public List<User> getAllUser();
    public User updateUser(String userId,User user);
}
