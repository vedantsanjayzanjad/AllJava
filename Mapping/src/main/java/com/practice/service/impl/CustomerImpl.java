package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Customer;
import com.practice.model.Orders;
import com.practice.repo.CustomerDao;
import com.practice.repo.OrdersDao;
import com.practice.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrdersDao orderDao;

	@Override
	public Customer createCustomers(Customer cust,int o_id) {
		Orders order = this.orderDao.findById(o_id).
		orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));
		cust.setOrder(order);
		Customer save = this.customerDao.save(cust);
		return save;
	}

	@Override
	public Customer updateCustomer(int cust_id, Customer cust) {
		Customer findById = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		
		findById.setCust_name(cust.getCust_name());
		findById.setCust_gender(cust.getCust_gender());

		Customer saveCust = this.customerDao.save(cust);
		return saveCust;
	}

	@Override
	public void deleteCustomer(int cust_id) {
		this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> findAll = this.customerDao.findAll();
		return findAll;
	}

	@Override
	public Customer getOnecustomer(int cust_id) {
		Customer cust = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		return cust;
	}

}
