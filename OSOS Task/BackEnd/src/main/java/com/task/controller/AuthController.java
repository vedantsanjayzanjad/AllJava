package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.exception.BadCredentials;
import com.task.service.UserRoleService;
import com.task.serviceimpl.UserImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class AuthController {

	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private UserRoleService userRoleImpl;

	
	@PostMapping(value = "/login")
	public UserRoles loginByUserRoles(@RequestBody User user) throws Exception {
		String username = user.getUsername();
		String userPassword = user.getPassword();

		User userObj = null;

		if (username != null && userPassword != null) {
			userObj = this.userImpl.fetchUserByUserNameAndPassword(username, userPassword);

		}
		if (userObj == null) {
			throw new BadCredentials(username, userPassword);

		}
		
		UserRoles userRolesByUser = this.userRoleImpl.getUserRolesByUser(userObj);

		return userRolesByUser;
	}
}


//	@GetMapping("/get/{id}")
//	public UserRoles getAllInOne(@PathVariable int id)
//	{
//		UserRoles one = this.userRole.getOne(id);
//		return one;
//	}
//	

//	@PostMapping(value = "/login")
//	public User loginAdmin(@RequestBody User user) throws Exception {
//		// System.out.println("pid :: " + userObj.getId());
//		String username = user.getUsername();
//		String userPassword = user.getPassword();
//
//		User userObj = null;
//
//		if (username != null && userPassword != null) {
//			userObj = this.userImpl.fetchUserByUserNameAndPassword(username, userPassword);
//
//		}
//		if (userObj == null) {
//			throw new BadCredentials(username, userPassword);
//
//		}
//
//		return userObj;
//	}
//	
//
//	@PostMapping(value = "/login/{username}/{password}")
//	public User loginNew(@PathVariable String username, @PathVariable String password) throws Exception {
//		// System.out.println("pid :: " + userObj.getId());
//		User user = new User();
//		user = null;
//
//		if (username != null && password != null) {
//			user = this.userImpl.fetchUserByUserNameAndPassword(username, password);
//
//		}
//		if (user == null) {
//			throw new BadCredentials(username, password);
//
//		}
//
//		return user;
//	}