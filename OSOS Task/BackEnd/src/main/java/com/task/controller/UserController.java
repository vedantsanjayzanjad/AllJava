package com.task.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Role;
import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.payloads.ApiResponse;
import com.task.serviceimpl.UserImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserImpl userImpl;

	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		Set<UserRoles> userRoles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(2);
		role.setRoleName("Normal");

		 UserRoles uRole = new UserRoles();

		 uRole.setRole(role);
		 uRole.setUser(user);
		 userRoles.add(uRole);

		 User createUser = this.userImpl.createUser(user, userRoles);
		 return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}

	@PostMapping("/admin")
	public ResponseEntity<User> createAdmin(@RequestBody User user) throws Exception {
		Set<UserRoles> userRoles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(1);
		role.setRoleName("Admin");

		UserRoles uRole = new UserRoles();

		uRole.setRole(role);
		uRole.setUser(user);
		userRoles.add(uRole);

		User createUser = this.userImpl.createUser(user, userRoles);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getuserByUsername(@PathVariable String username) {
		User userByUsername = this.userImpl.getUserByUsername(username);

		return new ResponseEntity<>(userByUsername, HttpStatus.FOUND);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int userId) {
		this.userImpl.deleteUserById(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("customer is deleted !!!", true), HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUser = this.userImpl.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.ACCEPTED);
	}

}
