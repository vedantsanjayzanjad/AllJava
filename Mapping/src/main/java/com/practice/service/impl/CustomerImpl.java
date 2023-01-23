package com.practice.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Customer;
import com.practice.model.Orders;
import com.practice.payloads.CustomerDto;
import com.practice.payloads.CustomerResponse;
import com.practice.repo.CustomerDao;
import com.practice.repo.OrdersDao;
import com.practice.service.CustomerService;

import jakarta.validation.Valid;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private OrdersDao orderDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto createCustomers(@Valid CustomerDto cust, int o_id) {
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));

		Customer map = this.modelMapper.map(cust, Customer.class);
		map.setOrder(order);
		Customer save = this.customerDao.save(map);
		return this.modelMapper.map(save, CustomerDto.class);
	}

	@Override
	public CustomerDto createCustomersOnly(@Valid CustomerDto cust) {

		Customer map = this.modelMapper.map(cust, Customer.class);
		Customer save = this.customerDao.save(map);
		return this.modelMapper.map(save, CustomerDto.class);
	}

	@Override
	public CustomerDto updateCustomer(@Valid int cust_id, CustomerDto cust, int o_id) {
		Customer findById = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrderId", o_id));
		findById.setCustName(cust.getCustName());
		findById.setCustGender(cust.getCustGender());
		findById.setOrder(order);
		Customer saveCust = this.customerDao.save(findById);
		return this.modelMapper.map(saveCust, CustomerDto.class);
	}

	@Override
	public void deleteCustomer(int cust_id) {
		Customer orElseThrow = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		this.customerDao.delete(orElseThrow);
	}

	@Override
	public CustomerResponse getAllCustomer(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		// List<Customer> findAll = this.customerDao.findAll();
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Customer> pagePost = this.customerDao.findAll(p);
		List<Customer> allCustomer = pagePost.getContent();
		List<CustomerDto> collect = allCustomer.stream().map((cust) -> this.modelMapper.map(cust, CustomerDto.class))
				.collect(Collectors.toList());
		CustomerResponse custResp = new CustomerResponse();
		custResp.setContent(collect);
		return custResp;
	}

	@Override
	public CustomerDto getOnecustomer(int cust_id) {
		Customer cust = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "customerId", cust_id));
		CustomerDto map = this.modelMapper.map(cust, CustomerDto.class);
		return map;
	}

	@Override
	public List<CustomerDto> getOneCustomerByOrders(int o_id) {
		Orders order = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "orderId", o_id));
		List<Customer> findByOrders = this.customerDao.findByOrder(order);
		List<CustomerDto> collect = findByOrders.stream().map((cust) -> this.modelMapper.map(cust, CustomerDto.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<CustomerDto> getCustByName(String cust_name) {

		List<Customer> findByCust_Name = this.customerDao
				.findByCustNameContainingIgnoreCaseOrderByCustGenderAsc(cust_name);
		List<CustomerDto> collect = findByCust_Name.stream()
				.map((cust) -> this.modelMapper.map(cust, CustomerDto.class)).collect(Collectors.toList());
		return collect;

	}

	@Override
	public List<CustomerDto> getCustNameLike(String keyword) {
		List<Customer> findByCustNameLike = this.customerDao.findByCustNameLike("%" + keyword + "%");
		// System.out.println(findByCustNameLike);
		List<CustomerDto> collect = findByCustNameLike.stream()
				.map((cust) -> this.modelMapper.map(cust, CustomerDto.class)).collect(Collectors.toList());

		return collect;
	}

	@Override
	public CustomerDto updateCustomerAndOrder(@Valid int cust_id, CustomerDto cust) {
		Customer orElseThrow = this.customerDao.findById(cust_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customers", "custId", cust_id));
		orElseThrow.setCustName(cust.getCustName());
		orElseThrow.setCustGender(cust.getCustGender());
		orElseThrow.setOrder(cust.getOrder());
		Customer saveCust = this.customerDao.save(orElseThrow);
		CustomerDto map = this.modelMapper.map(saveCust, CustomerDto.class);
		return map;

	}

	@Override
	public CustomerDto UpdateCustomerByFields(int cust_id, CustomerDto fields) {
		Customer existingCustomer = this.customerDao.findById(cust_id).get();
		existingCustomer.setOrder(fields.getOrder());
		this.customerDao.save(existingCustomer);
		return this.modelMapper.map(existingCustomer, CustomerDto.class);
	}
}
