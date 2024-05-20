package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.User;
import com.exam.service.impl.AuthenticationServiceImpl;



@RestController
@CrossOrigin("*")
public class AuthenticationController {
	

	@Autowired
	AuthenticationServiceImpl authenticationServiceImpl;
	
	
	@GetMapping("/api/authenticateUser/{userName}/{password}") 
	public User authenticateUser(@PathVariable  String userName, @PathVariable  String password) throws Exception {
		
		return authenticationServiceImpl.authenticateUser(userName, password);
	}


}
