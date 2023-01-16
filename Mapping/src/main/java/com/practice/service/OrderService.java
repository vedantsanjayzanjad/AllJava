package com.practice.service;

import java.util.List;

import com.practice.model.Customer;
import com.practice.model.Orders;

public interface OrderService {

	public Orders createOrders(Orders order);

	public Orders updateOrders(int o_id, Orders order);

	public void deleteOrders(int o_id);

	public List<Orders> getAllOrders();

	public Orders getOneOrder(int o_id);
}
