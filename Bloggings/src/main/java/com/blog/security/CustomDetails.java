package com.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.exceptions.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.reposistories.UserDao;

@Service
public class CustomDetails implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user form database by username
		
		User user = this.userDao.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email :" + username,0));
		return user;
	}

}
