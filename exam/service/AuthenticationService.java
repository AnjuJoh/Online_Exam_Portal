package com.exam.service;

import com.exam.model.User;

public interface AuthenticationService {
	
	public User authenticateUser(String username, String password) throws Exception;

}
