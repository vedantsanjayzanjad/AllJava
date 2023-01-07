package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService 
{
	//Create
	public User createIser(User user);
	
	//Get All
	List <User> getAllUser();
	
	//Get One
	public User getOneUser(String userId);
}
