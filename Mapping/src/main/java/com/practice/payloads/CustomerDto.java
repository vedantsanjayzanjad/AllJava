package com.practice.payloads;

import com.practice.model.Orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private int custId;

	private String custName;

	private String custGender;
	
	private Orders order;
	
	
}
