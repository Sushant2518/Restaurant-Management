package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.OrderService;
import com.masai.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/createorder")
	ResponseEntity<Order> createorder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Order>> getAll(){
		return new ResponseEntity<List<Order>>(orderService.getAllOrder(), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Order> deleteorder(@RequestParam ("id") long id){
		return new ResponseEntity<Order>(orderService.deleteOrder(id), HttpStatus.OK);
	}

}
