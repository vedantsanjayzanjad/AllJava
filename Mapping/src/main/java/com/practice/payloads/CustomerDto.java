package com.practice.payloads;

import java.util.HashSet;

import java.util.Set;

import com.practice.model.Customer;
import com.practice.model.Orders;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

	private int custId;

	private String custName;

	private String custGender;

	private int custSalary;
	
	private String fileName;

	private Orders order;
	
//	private Set<Orders> order = new HashSet<>();
	
}
