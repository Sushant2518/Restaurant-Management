package com.masai.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.MenuItemRepository;
import com.masai.Repository.OrderItemRepository;
import com.masai.Repository.OrderRepository;
import com.masai.Services.OrderItemService;
import com.masai.model.MenuItem;
import com.masai.model.Order;
import com.masai.model.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderRepository orderRep;
	@Autowired
	private OrderItemRepository orderItemRepo;
	@Autowired
	private MenuItemRepository menuItemRepo;

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		Order order = orderRep.findById(orderItem.getOrder().getId())
				.orElseThrow(() -> new RuntimeException("No Order Found"));
		MenuItem menuItem = menuItemRepo.findById(orderItem.getMenuItem().getId())
				.orElseThrow(() -> new RuntimeException("Menu Item not Found"));
		orderItem.setOrder(order);
		orderItem.setMenuItem(menuItem);
		return orderItemRepo.save(orderItem);
	}

	@Override
	public OrderItem deleteordeItem(long id) {
		OrderItem orderItem= orderItemRepo.findById(id).orElseThrow(()-> new RuntimeException("No Order Item found"));
		orderItemRepo.delete(orderItem);
		return orderItem;
	}

}
