package com.exam.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.exam.Quiz;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user

	@Override
	public User registerUser(User user) throws Exception {

		if (user.getRole() == null) {
		Role role = roleRepository.findByRoleName("NORMAL");
		user.setRole(role);
		}
		return userRepository.save(user);
	}

	
	@Override
	public List<User> getUsers() {

		List<User> usersList = new ArrayList<>();
		usersList = userRepository.findAll();
		return usersList;
	}

	@Override
	public User updateUser(User user) throws Exception {
		return userRepository.save(user);
	}


	public User getUser(Long id) throws Exception {
		
		Optional<User> user =  userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new Exception("User not found!!");
		}
	}



}
