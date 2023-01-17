package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	public Customer createCustomers(Customer cust, int o_id) {
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));
		cust.setOrder(order);
		Customer save = this.customerDao.save(cust);
		return save;
	}

	@Override
	public Customer updateCustomer(int cust_id, Customer cust, int o_id) {
		Customer findById = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));
		cust.setCustName(cust.getCustName());
		cust.setCustGender(cust.getCustGender());
		findById.setOrder(order);
		Customer saveCust = this.customerDao.saveAndFlush(findById);
		return saveCust;
	}

	@Override
	public void deleteCustomer(int cust_id) {
		Customer orElseThrow = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		this.customerDao.delete(orElseThrow);
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

	@Override
	public List<Customer> getOneCustomerByOrders(int o_id) {
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "orderId", o_id));
		List<Customer> findByOrders = this.customerDao.findByOrder(order);
		return findByOrders;
	}

	@Override
	public List<Customer> getCustByName(String cust_name) {
		
		List<Customer> findByCust_Name = this.customerDao.findByCustNameContainingIgnoreCase(cust_name);
		return findByCust_Name;

	}

	@Override
	public List<Customer> getCustNameLike(String keyword) {
		List<Customer> findByCustNameLike = this.customerDao.findByCustNameLike("%"+keyword+"%");
		return findByCustNameLike;
	}
	
	
}
