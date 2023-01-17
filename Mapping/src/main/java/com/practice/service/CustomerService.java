package com.practice.service;

import java.util.List;

import com.practice.model.Customer;

public interface CustomerService {

	public Customer createCustomers(Customer cust,int o_id);
	
	public Customer createCustomersOnly(Customer cust);
	
	public Customer updateCustomer(int cust_id,Customer cust,int o_id);
	
	public void deleteCustomer(int cust_id);
	
	public List<Customer> getAllCustomer();
	
	public Customer getOnecustomer(int cust_id);

	List<Customer> getOneCustomerByOrders(int o_id);
	
	public List<Customer> getCustByName(String cust_name);

	List<Customer> getCustNameLike(String keyword);
	
}
