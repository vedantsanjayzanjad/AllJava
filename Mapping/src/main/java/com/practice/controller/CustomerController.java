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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.Customer;
import com.practice.payloads.ApiResponse;
import com.practice.payloads.AppConstant;
import com.practice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custServ;

	@PostMapping("/cust/{o_id}")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cust, @PathVariable int o_id) {
		Customer createCustomers = this.custServ.createCustomers(cust, o_id);
		return new ResponseEntity<Customer>(createCustomers, HttpStatus.CREATED);
	}
	
	@PostMapping("/cust")
	public ResponseEntity<Customer> saveCustomerOnly(@RequestBody Customer cust) {
		Customer createCustomers = this.custServ.createCustomersOnly(cust);
		return new ResponseEntity<Customer>(createCustomers, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomer(	
			@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir) {
		List<Customer> allCustomer = this.custServ.getAllCustomer(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.FOUND);
	}

	@GetMapping("/getOne/{cust_id}")
	public ResponseEntity<Customer> getOneCustomer(@PathVariable int cust_id) {
		Customer allCustomer = this.custServ.getOnecustomer(cust_id);
		return new ResponseEntity<Customer>(allCustomer, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteCust/{cust_id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable int cust_id) {
		this.custServ.deleteCustomer(cust_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("customer is deleted !!!", true), HttpStatus.FOUND);
	}

	@PutMapping("/cust/{cust_id}/orders/{o_id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust, @PathVariable int cust_id,
			@PathVariable int o_id) {
		Customer updateCustomer = this.custServ.updateCustomer(cust_id, cust, o_id);
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/cust/{cust_id}/orders")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust, @PathVariable int cust_id) {
		Customer updateCustomer = this.custServ.updateCustomerAndOrder(cust_id, cust);
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);
	}

	@GetMapping("/{o_id}/orders")
	public ResponseEntity<List<Customer>> getOneCustomerByOrder(@PathVariable int o_id)
	{
		List<Customer> oneCustomerByOrders = this.custServ.getOneCustomerByOrders(o_id);
		return new ResponseEntity<List<Customer>>(oneCustomerByOrders,HttpStatus.FOUND);
	}
	
	@GetMapping("/orders/{cust_name}")
	public ResponseEntity<List<Customer>> getOneCustomerByOrder(@PathVariable String cust_name)
	{
		List<Customer> oneCustomerByOrders = this.custServ.getCustByName(cust_name);
		return new ResponseEntity<List<Customer>>(oneCustomerByOrders,HttpStatus.FOUND);
	}
	
	@GetMapping("/cust/orders/{keyword}")
	public ResponseEntity<List<Customer>> getCustNameLike(@PathVariable String keyword)
	{
		List<Customer> oneCustomerByOrders = this.custServ.getCustNameLike(keyword);
		return new ResponseEntity<List<Customer>>(oneCustomerByOrders,HttpStatus.FOUND);
	}
	
}
