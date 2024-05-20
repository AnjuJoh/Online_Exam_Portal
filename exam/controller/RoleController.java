package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.service.impl.RoleServiceImpl;

@RestController
@CrossOrigin("*")
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;

	@PostMapping("/api/saveRole")
	public Role saveRole(@RequestBody Role role) throws Exception {
		return roleServiceImpl.saveRole(role);
	}

	@GetMapping("/api/getRoles")
	public ResponseEntity<List<Role>> getAllRoles() throws Exception {
		return ResponseEntity.ok(this.roleServiceImpl.getRoles());
	}
	
	@GetMapping("/api/getRole/{id}")
	public Role getRole(@PathVariable("id") Long id) throws Exception {
		return this.roleServiceImpl.getRole(id);
	}
	
	@DeleteMapping("/api/deleteRole/{id}")
	public void deleteRole(@PathVariable("id") Long id) throws Exception {
		 this.roleServiceImpl.deleteRole(id);
	}

	@PutMapping("/api/updateRole")
	public ResponseEntity<?> updateAllUsers(@RequestBody Role role) throws Exception {
		return ResponseEntity.ok(this.roleServiceImpl.updateRole(role));
	}

}
