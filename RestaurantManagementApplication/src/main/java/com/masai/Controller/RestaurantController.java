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

import com.masai.Services.RestaurantService;
import com.masai.model.Restaurant;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	@PostMapping("/create")
	public ResponseEntity<Restaurant> createRest(@RequestBody Restaurant rest){
		Restaurant resta= restaurantService.addRestaurant(rest);
		return new ResponseEntity<Restaurant>(resta, HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Restaurant> delete(@RequestParam("id") long id){
		Restaurant resta= restaurantService.deleteRestaurant(id);
		return new ResponseEntity<Restaurant>(resta, HttpStatus.OK);
	}
}
