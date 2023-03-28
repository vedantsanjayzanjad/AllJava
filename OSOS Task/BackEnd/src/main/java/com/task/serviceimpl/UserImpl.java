package com.task.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.repository.RoleRepo;
import com.task.repository.UserRepo;
import com.task.repository.UserRolesRepo;
import com.task.service.UserService;

@Service
public class UserImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRolesRepo userRole;

	@Override
	public User createUser(User user,Set<UserRoles> userRoles) throws Exception {
		User localUser = this.userRepo.findByUsername(user.getUsername());
		
		if (localUser != null) {
			System.out.println("User is Already Present!!");
			throw new Exception("User is already Present!!!");
	} 
		else {
			for (UserRoles ur : userRoles) {
				roleRepo.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			localUser = this.userRepo.save(user);
		}
		return localUser;
	}

	@Override
	public User getUserByUsername(String username) {

		return this.userRepo.findByUsername(username);

	}

	@Override
	public void deleteUserById(int userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new com.task.exception.ResourceNotFoundException("User", "UserId", userId));
		this.userRepo.delete(user);
	}

	@Override
	public User fetchUserByUserNameAndPassword(String username, String tempPassword) {
		return this.userRepo.findByUsernameAndPassword(username, tempPassword);
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = this.userRepo.findAll();
		return findAll;
	}

}
