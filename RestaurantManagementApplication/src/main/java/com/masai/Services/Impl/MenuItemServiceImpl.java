package com.masai.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.MenuItemRepository;
import com.masai.Repository.MenuRepository;
import com.masai.Services.MenuItemService;
import com.masai.model.Menu;
import com.masai.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepo;
	@Autowired
	private MenuRepository menuRepo;

	@Override
	public MenuItem createMenuItem(MenuItem menuItem) {
		Menu menu = menuRepo.findById(menuItem.getMenu().getId())
				.orElseThrow(() -> new RuntimeException("Menu Not Found"));
		menuItem.setMenu(menu);
		return menuItemRepo.save(menuItem);
	}

	@Override
	public MenuItem deleteMenuItem(Long id) {
		MenuItem menuItem = menuItemRepo.findById(id).orElseThrow(() -> new RuntimeException("No Menu Item Found"));
		menuItemRepo.delete(menuItem);
		return menuItem;
	}

}
