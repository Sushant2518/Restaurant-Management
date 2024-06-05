package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	Optional<Restaurant> findByEmail(String email);
}
