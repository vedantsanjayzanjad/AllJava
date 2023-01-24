package com.practice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.Customer;
import com.practice.model.Orders;
import com.practice.payloads.ApiResponse;
import com.practice.payloads.AppConstant;
import com.practice.payloads.CustomerDto;
import com.practice.payloads.CustomerResponse;
import com.practice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custServ;

	@PostMapping("/cust/{o_id}")
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto cust, @PathVariable int o_id) {
		CustomerDto createCustomers = this.custServ.createCustomers(cust, o_id);
		return new ResponseEntity<CustomerDto>(createCustomers, HttpStatus.CREATED);
	}

	@PostMapping("/cust")
	public ResponseEntity<CustomerDto> saveCustomerOnly(@RequestBody CustomerDto cust) {
		CustomerDto createCustomers = this.custServ.createCustomersOnly(cust);
		return new ResponseEntity<CustomerDto>(createCustomers, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<CustomerResponse> getAllCustomer(
			@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir) {
		CustomerResponse allCustomer = this.custServ.getAllCustomer(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<CustomerResponse>(allCustomer, HttpStatus.FOUND);
	}

	@GetMapping("/getOne/{cust_id}")
	public ResponseEntity<CustomerDto> getOneCustomer(@PathVariable int cust_id) {
		CustomerDto allCustomer = this.custServ.getOnecustomer(cust_id);
		return new ResponseEntity<CustomerDto>(allCustomer, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteCust/{cust_id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable int cust_id) {
		this.custServ.deleteCustomer(cust_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("customer is deleted !!!", true), HttpStatus.FOUND);
	}

	@PutMapping("/cust/{cust_id}/orders/{o_id}")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto cust, @PathVariable int cust_id,
			@PathVariable int o_id) {
		CustomerDto updateCustomer = this.custServ.updateCustomer(cust_id, cust, o_id);
		return new ResponseEntity<CustomerDto>(updateCustomer, HttpStatus.OK);
	}

	@PutMapping("/cust/{cust_id}/orders")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto cust, @PathVariable int cust_id) {
		CustomerDto updateCustomer = this.custServ.updateCustomerAndOrder(cust_id, cust);
		return new ResponseEntity<CustomerDto>(updateCustomer, HttpStatus.OK);
	}

	@GetMapping("/{o_id}/orders")
	public ResponseEntity<List<CustomerDto>> getOneCustomerByOrder(@PathVariable int o_id) {
		List<CustomerDto> oneCustomerByOrders = this.custServ.getOneCustomerByOrders(o_id);
		return new ResponseEntity<List<CustomerDto>>(oneCustomerByOrders, HttpStatus.FOUND);
	}

	@GetMapping("/orders/{cust_name}")
	public ResponseEntity<List<CustomerDto>> getOneCustomerByOrder(@PathVariable String cust_name) {
		List<CustomerDto> oneCustomerByOrders = this.custServ.getCustByName(cust_name);
		return new ResponseEntity<List<CustomerDto>>(oneCustomerByOrders, HttpStatus.FOUND);
	}

	@GetMapping("/cust/orders/{keyword}")
	public ResponseEntity<List<CustomerDto>> getCustNameLike(@PathVariable String keyword) {
		List<CustomerDto> oneCustomerByOrders = this.custServ.getCustNameLike(keyword);
		return new ResponseEntity<List<CustomerDto>>(oneCustomerByOrders, HttpStatus.FOUND);
	}
	
	
	@PatchMapping("/partial/{cust_id}")
	public ResponseEntity<CustomerDto> getPartialUpdateOfCustomer
	(@PathVariable int cust_id, @RequestBody CustomerDto fields)
	{
		CustomerDto updateCustomer  = this.custServ.UpdateCustomerByFields(cust_id,fields);
		return new ResponseEntity<CustomerDto>(updateCustomer,HttpStatus.OK);
	}
}
