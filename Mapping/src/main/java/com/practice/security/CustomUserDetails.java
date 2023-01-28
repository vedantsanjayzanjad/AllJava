package com.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Customer;
import com.practice.repo.CustomerDao;

@Service
public class CustomUserDetails implements UserDetailsService {

	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Customer customer = this.customerDao.findByCustName(username)
		.orElseThrow(() ->  new ResourceNotFoundException("Customer", "CustomerName " + username,0 ));
		return customer;
	}
	
	
	

}
