package com.task.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.UserRolesRepo;
import com.task.service.UserRoleService;

@Service
public class UserRolesImpl implements UserRoleService{

	
	@Autowired
	private UserRolesRepo userRoleRepo;
	
	@Override
	public UserRoles getOne(int id) {
	
		UserRoles details = this.userRoleRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("UserRole","UserRoleId", id));
		return details;
	}

	@Override
	public UserRoles getUserRolesByUser(User user) {
		UserRoles userAndRoles = this.userRoleRepo.findByuser(user);
		return userAndRoles;
	}

	
}
