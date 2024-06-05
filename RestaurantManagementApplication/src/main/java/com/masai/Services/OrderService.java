package com.masai.Services;

import java.util.List;

import com.masai.model.Order;

public interface OrderService {
	public Order createOrder(Order order);

	public Order deleteOrder(long id);

	public List<Order> getAllOrder();
}
