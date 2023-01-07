package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User savedUser = this.userService.createIser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getOneUser(@PathVariable String userId)
	{
		User user  = this.userService.getOneUser(userId);
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> user  = this.userService.getAllUser();
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
}
