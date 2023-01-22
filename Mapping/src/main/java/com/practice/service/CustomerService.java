package com.practice.service;

import java.util.List;
import java.util.Map;
import com.practice.payloads.CustomerDto;
import com.practice.payloads.CustomerResponse;

public interface CustomerService {

	public CustomerDto createCustomers(CustomerDto cust,int o_id);
	
	public CustomerDto createCustomersOnly(CustomerDto cust);
	
	public CustomerDto updateCustomer(int cust_id,CustomerDto cust,int o_id);
	
	public CustomerDto updateCustomerAndOrder(int cust_id,CustomerDto cust);
	
	public void deleteCustomer(int cust_id);
	
	public CustomerResponse getAllCustomer(Integer pageNumber,Integer pageSize,String sortBy, String sortDir);
	
	public CustomerDto getOnecustomer(int cust_id);

	List<CustomerDto> getOneCustomerByOrders(int o_id);
	
	public List<CustomerDto> getCustByName(String cust_name);

	List<CustomerDto> getCustNameLike(String keyword);

	public CustomerDto UpdateCustomerByFields(int cust_id, Map<String, Object> fields);

}
