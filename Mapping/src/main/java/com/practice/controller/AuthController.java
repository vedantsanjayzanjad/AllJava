package com.practice.controller;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.exception.ApiException;
import com.practice.model.Customer;
import com.practice.payloads.CustomerDto;
import com.practice.payloads.JwtAuthRequest;
import com.practice.payloads.JwtAuthResponse;
import com.practice.security.JwtTokenHelper;
import com.practice.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {


	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerService custServ;

	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setCust(this.mapper.map((Customer) userDetails, CustomerDto.class));
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {

			this.authenticationManager.authenticate(authenticationToken);
		

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");
		}

	}
	
	 @PostMapping("/register")
	    public ResponseEntity<CustomerDto> registeredUser(@Valid @RequestBody CustomerDto customerDto)
	    {
	    	CustomerDto registeredUser = this.custServ.registeredUser(customerDto);
	    	return new ResponseEntity<CustomerDto>(registeredUser,HttpStatus.CREATED);
	    }

		
}
