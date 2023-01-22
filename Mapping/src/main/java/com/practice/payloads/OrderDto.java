package com.practice.payloads;

import com.practice.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto 
{
	private int o_id;
	
	private String start_date;
	
	private String end_date;
	
	private Customer cust;
}
