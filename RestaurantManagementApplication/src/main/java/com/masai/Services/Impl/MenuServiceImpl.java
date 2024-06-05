package com.masai.Services.Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.MenuRepository;
import com.masai.Repository.RestaurantRepository;
import com.masai.Services.MenuService;
import com.masai.model.Menu;
import com.masai.model.Restaurant;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menurepo;
	@Autowired
	private RestaurantRepository restRepo;

	@Override
	public Menu addMenu(Menu menu) {
		Optional<Menu> men = menurepo.findByName(menu.getName());
		if (men.isPresent()) {
			throw new RuntimeException("Menu with name is already Present");
		}
		menu.setMenuItems(new ArrayList<>());
		Restaurant rest = restRepo.findById(menu.getRestaurant().getId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));
		menu.setRestaurant(rest);
		return menurepo.save(menu);
	}

	@Override
	public Menu deleteMenu(long id) {
		Menu menu = menurepo.findById(id).orElseThrow(() -> new RuntimeException("Menu Not found"));
		menurepo.delete(menu);
		return menu;
	}

	@Override
	public List<Menu> findAll() {
		List<Menu> list = menurepo.findAll();
		if (list.isEmpty()) {
			throw new RuntimeException("No menu present");
		}
		return list;
	}

}
