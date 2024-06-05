package com.masai.Services.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.RestaurantRepository;
import com.masai.Repository.TablesRepository;
import com.masai.Services.TablesService;
import com.masai.model.Restaurant;
import com.masai.model.Tables;

@Service
public class TablesServiceImpl implements TablesService {
	@Autowired
	private TablesRepository tableRepo;
	@Autowired
	private RestaurantRepository restRepo;

	@Override
	public Tables createTable(Tables table) {
		table.setReservations(new ArrayList<>());
		Restaurant rest = restRepo.findById(table.getRestaurant().getId())
				.orElseThrow(() -> new RuntimeException("No Restaurant found"));
		table.setRestaurant(rest);
		return tableRepo.save(table);
	}

	@Override
	public Tables deleteTable(long id) {
		Tables table= tableRepo.findById(id).orElseThrow(()-> new RuntimeException("no table found"));
		tableRepo.deleteById(id);
		return table;
	}

}
