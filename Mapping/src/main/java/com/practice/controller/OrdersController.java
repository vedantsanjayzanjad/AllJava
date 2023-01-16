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
import org.springframework.web.bind.annotation.RestController;
import com.practice.model.Orders;
import com.practice.payloads.ApiResponse;
import com.practice.service.impl.OrdersImpl;

@RestController("orders")
public class OrdersController {

	@Autowired
	private OrdersImpl orderImpl;
	
	
	@PostMapping("/order")
	public ResponseEntity<Orders> saveOrders(@RequestBody Orders order)
	{
		Orders createOrders = this.orderImpl.createOrders(order);
		return new ResponseEntity<Orders>(createOrders,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Orders>> getAllOrders()
	{
		List<Orders> allOrders = this.orderImpl.getAllOrders();
		return new ResponseEntity<List<Orders>>(allOrders,HttpStatus.FOUND);
	}
	
	@GetMapping("/getOne/{o_id}")
	public ResponseEntity<Orders> getOneCustomer(@PathVariable int o_id)
	{
		Orders allOrders = this.orderImpl.getOneOrder(o_id);
		return new ResponseEntity<Orders>(allOrders,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteOrders/{o_id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable int o_id)
	{
		this.orderImpl.deleteOrders(o_id);
		return new ResponseEntity<ApiResponse>
		(new ApiResponse("Order is deleted !!!",true),HttpStatus.FOUND);
	}
	
	@PutMapping("/order/{o_id}")
	public ResponseEntity<Orders> updateOrders
	(@RequestBody Orders order,@PathVariable int o_id)
	{
		Orders updateOrders = this.orderImpl.updateOrders(o_id, order);
		return new ResponseEntity<Orders>(updateOrders,HttpStatus.OK);
	}	

}
