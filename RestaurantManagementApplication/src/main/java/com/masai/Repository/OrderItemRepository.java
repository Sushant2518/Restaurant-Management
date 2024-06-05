package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
