package com.practice.payloads;
import java.util.Set;

import com.practice.model.Customer;

import lombok.Data;

@Data
public class JwtAuthResponse 
{

	private String token;
	
	private CustomerDto cust;
}
