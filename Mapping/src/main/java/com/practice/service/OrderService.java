package com.practice.service;

import java.util.List;

import com.practice.payloads.OrderDto;
import com.practice.repo.OrdersDao;

public interface OrderService 
{

	public OrderDto createOrders(OrderDto order);

	public OrderDto updateOrders(int o_id, OrderDto order);

	public void deleteOrders(int o_id);

	public List<OrderDto> getAllOrders();

	public OrderDto getOneOrder(int o_id);
}
