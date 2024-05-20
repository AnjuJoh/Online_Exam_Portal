package com.exam.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.repo.RoleRepository;
import com.exam.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
		
		@Autowired
		private RoleRepository roleRepository;

		@Override
		public Role saveRole(Role role) throws Exception {
			
		 Role existingRole= roleRepository.findByRoleName(role.getRoleName());
			
			if (existingRole  != null) {
			  throw new Exception("Role already exist !!!");
			}
		 return roleRepository.save(role);
		}
		
		@Override
		public List<Role> getRoles() {
			return new ArrayList<>(roleRepository.findAll());
		}

		@Override
		public Role updateRole(Role role) {
			return roleRepository.save(role);
		}

		@Override
		public Role getRole(Long id) throws Exception {
			
			Optional<Role> role =  roleRepository.findById(id);
			
			if (role.isPresent()) {
				return role.get();
			} else {
				throw new Exception("Role not found!!");
			}
		
		}

		@Override
		public void deleteRole(Long id) throws Exception {
			
			roleRepository.deleteById(id);
		}
}