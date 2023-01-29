package com.practice.payloads;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	
	private String password;

	private String custGender;

	private int custSalary;
	
	private String fileName;

	private Orders order;
	
//	private Set<Orders> order = new HashSet<>();
	
	private Set<RoleDto> roles = new HashSet<>();
	

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password=password;
	}
	
}
