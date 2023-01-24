package com.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Customer;
import com.practice.model.Orders;
import com.practice.payloads.OrderDto;
import com.practice.repo.CustomerDao;
import com.practice.repo.OrdersDao;
import com.practice.service.OrderService;

@Service
public class OrdersImpl implements OrderService {

	@Autowired
	private OrdersDao orderDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderDto createOrders(OrderDto order) {
		Orders map = this.modelMapper.map(order, Orders.class);
		map.setCust(order.getCust());
		Orders save = this.orderDao.save(map);
		return this.modelMapper.map(save, OrderDto.class);
	}

	@Override
	public OrderDto updateOrders(int o_id, OrderDto order) {
		Orders findById = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));

		findById.setStart_date(order.getStart_date());
		findById.setEnd_date(order.getEnd_date());
		findById.setCust(order.getCust());

		Orders map = this.modelMapper.map(findById, Orders.class);
		Orders saveCust = this.orderDao.save(map);
		return this.modelMapper.map(saveCust, OrderDto.class);
	}

	@Override
	public void deleteOrders(int o_id) {
		Orders orElseThrow = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));
		this.orderDao.delete(orElseThrow);
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<Orders> findAll = this.orderDao.findAll();
		List<OrderDto> collect = findAll
				.stream()
				.map((order)->this.modelMapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public OrderDto getOneOrder(int o_id) {
		Orders cust = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));
		return this.modelMapper.map(cust,OrderDto.class);
	}
}
