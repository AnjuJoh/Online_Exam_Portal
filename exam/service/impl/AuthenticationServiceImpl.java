package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.repo.UserRepository;
import com.exam.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	
	@Autowired
	private UserRepository userRepository;

	public User authenticateUser(String username, String password) throws Exception {
				
		User user = userRepository.findByUserNameAndPassword(username, password);
		
		if (user == null) {
			throw new Exception("invalid");
		} 
		
		return user;
		
	}

}
