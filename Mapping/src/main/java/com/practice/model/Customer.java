package com.practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cust_id;
	
	private String cust_name;
	
	private String cust_gender;
	
	@OneToOne
	private Orders order;
}
