package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.OrderItemService;
import com.masai.model.OrderItem;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;
	@PostMapping("/create")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderitem){
		return new ResponseEntity<OrderItem>(orderItemService.createOrderItem(orderitem), HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<OrderItem> delete(@RequestParam("id") long id){
		return new ResponseEntity<OrderItem>(orderItemService.deleteordeItem(id), HttpStatus.ACCEPTED);
	}
} 
