package com.exam.service;

import java.util.List;
import java.util.Set;
import com.exam.model.Role;

public interface RoleService {
	
	public Role saveRole(Role role) throws Exception;

	public List<Role> getRoles();
	
	public Role updateRole(Role role);

	public Role getRole(Long id) throws Exception;

	public void deleteRole(Long id) throws Exception;


}
