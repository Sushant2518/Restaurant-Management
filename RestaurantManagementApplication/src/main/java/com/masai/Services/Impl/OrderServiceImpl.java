package com.masai.Services.Impl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.Repository.OrderRepository;
import com.masai.Services.OrderService;
import com.masai.model.Order;
import com.masai.model.User;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Order createOrder(Order order) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		order.setUser(user);
		order.setOrderItems(new ArrayList<>());
		order.setOrderDate(LocalDateTime.now());
		return orderRepo.save(order);
	}

	@Override
	public Order deleteOrder(long id) {
		Order order= orderRepo.findById(id).orElseThrow(()->new RuntimeException("No order found"));
		orderRepo.delete(order);
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		
		return orderRepo.findAll();
	}

}
