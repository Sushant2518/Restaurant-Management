package com.masai.Services;

import com.masai.model.Restaurant;

public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant deleteRestaurant(long id);
}
