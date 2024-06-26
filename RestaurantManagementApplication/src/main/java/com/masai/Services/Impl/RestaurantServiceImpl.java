package com.masai.Services.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.RestaurantRepository;
import com.masai.Services.RestaurantService;
import com.masai.model.Restaurant;


@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
    private RestaurantRepository restRepo;
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		Optional<Restaurant> rest= restRepo.findByEmail(restaurant.getEmail());
		if(rest.isPresent()) {
			throw new RuntimeException("This Restaurant is already Registered");
		}
		restaurant.setMenus(new ArrayList<>());
		restaurant.setTables(new ArrayList<>());
		
		return restRepo.save(restaurant);
	}

	@Override
	public Restaurant deleteRestaurant(long id) {
		Restaurant rest= restRepo.findById(id).orElseThrow(()->new RuntimeException("Restaurant not found"));
		restRepo.delete(rest);
		return rest;
	}

}
