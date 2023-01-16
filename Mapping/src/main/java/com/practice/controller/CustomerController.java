package com.practice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Customer;
import com.practice.payloads.ApiResponse;
import com.practice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custServ;
	
	
	@PostMapping("/cust/{o_id}")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cust,@PathVariable int o_id)
	{
		Customer createCustomers = this.custServ.createCustomers(cust,o_id);
		return new ResponseEntity<Customer>(createCustomers,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		List<Customer> allCustomer = this.custServ.getAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.FOUND);
	}
	
	@GetMapping("/getOne/{cust_id}")
	public ResponseEntity<Customer> getOneCustomer(@PathVariable int cust_id)
	{
		Customer allCustomer = this.custServ.getOnecustomer(cust_id);
		return new ResponseEntity<Customer>(allCustomer,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteCust/{cust_id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable int cust_id)
	{
		this.custServ.deleteCustomer(cust_id);
		return new ResponseEntity<ApiResponse>
		(new ApiResponse("customer is deleted !!!",true),HttpStatus.FOUND);
	}
	
	@PutMapping("/cust/{cust_id}/orders/{o_id}")
	public ResponseEntity<Customer> updateCustomer
	(@RequestBody Customer cust,@PathVariable int cust_id,@PathVariable int o_id)
	{
		Customer updateCustomer = this.custServ.updateCustomer(cust_id, cust,o_id);
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}	
}
