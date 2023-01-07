package com.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.repositories.UserDao;
import com.user.service.UserService;

@Service
public class ServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	public User createIser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		User savedUser  = this.userDao.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		
	List <User> user = this.userDao.findAll();
	return user;
	}

	@Override
	public User getOneUser(String userId) {
		
		User user = this.userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		return user;
	}
	
}
