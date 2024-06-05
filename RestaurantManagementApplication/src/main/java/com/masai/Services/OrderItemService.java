package com.masai.Services;

import com.masai.model.OrderItem;

public interface OrderItemService {
	public OrderItem createOrderItem(OrderItem orderItem);

	public OrderItem deleteordeItem(long id);
}
