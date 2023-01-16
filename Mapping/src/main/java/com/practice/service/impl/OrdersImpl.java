package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Customer;
import com.practice.model.Orders;
import com.practice.repo.CustomerDao;
import com.practice.repo.OrdersDao;
import com.practice.service.OrderService;

@Service
public class OrdersImpl implements OrderService{
	
	@Autowired
	private OrdersDao orderDao;

	@Override
	public Orders createOrders(Orders order) {
		Orders save = this.orderDao.save(order);
		return save;
	}

	@Override
	public Orders updateOrders(int o_id, Orders order) {
		Orders findById = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));

		findById.setStart_date(order.getStart_date());
		findById.setEnd_date(order.getEnd_date());

		Orders saveCust = this.orderDao.save(order);
		return saveCust;
	}

	@Override
	public void deleteOrders(int o_id) {
		Orders orElseThrow = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));
		this.orderDao.delete(orElseThrow);
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> findAll = this.orderDao.findAll();
		return findAll;
	}

	@Override
	public Orders getOneOrder(int o_id) {
		Orders cust = this.orderDao.findById(o_id)
				.orElseThrow(() -> new ResourceNotFoundException("Orders", "OrdersId", o_id));
		return cust;
	}
}
