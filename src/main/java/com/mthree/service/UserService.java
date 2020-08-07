package com.mthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.entity.User;
import com.mthree.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	
	public User getUserByUserName(String username) {
		return userRepo.findUserByUserName(username);
	}
}
