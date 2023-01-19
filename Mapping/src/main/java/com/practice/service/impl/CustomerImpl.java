package com.practice.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Customer createCustomersOnly(Customer cust) {
		Customer save = this.customerDao.save(cust);
		return save;
	}

	@Override
	public Customer updateCustomer(int cust_id, Customer cust, int o_id) {
		Customer findById = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));
		findById.setCustName(cust.getCustName());
		findById.setCustGender(cust.getCustGender());
		findById.setOrder(order);
		Customer saveCust = this.customerDao.save(findById);
		return saveCust;
	}

	@Override
	public void deleteCustomer(int cust_id) {
		Customer orElseThrow = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		this.customerDao.delete(orElseThrow);
	}

	@Override
	public List<Customer> getAllCustomer(Integer pageNumber,Integer pageSize,String sortBy, String sortDir) {
	    Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		  Pageable p = PageRequest.of(pageNumber, pageSize,sort);
		  Page<Customer> pagePost = this.customerDao.findAll(p);
		  List<Customer> allCustomer = pagePost.getContent();
		  //List<Customer> findAll = this.customerDao.findAll();
		  return allCustomer;
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

		List<Customer> findByCust_Name = this.customerDao.findByCustNameContainingIgnoreCaseOrderByCustGenderAsc(cust_name);
		return findByCust_Name;

	}

	@Override
	public List<Customer> getCustNameLike(String keyword) {
		List<Customer> findByCustNameLike = this.customerDao.findByCustNameLike("%" + keyword + "%");
		//System.out.println(findByCustNameLike);
		return findByCustNameLike;
	}

	@Override
	public Customer updateCustomerAndOrder(int cust_id, Customer cust)
	{
		Customer orElseThrow = this.customerDao
				.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers","custId",cust_id));
		orElseThrow.setCustName(cust.getCustName());
		orElseThrow.setCustGender(cust.getCustGender());
		orElseThrow.setOrder(cust.getOrder());
		Customer saveCust = this.customerDao.save(orElseThrow);
		return saveCust;
		
	}


}
