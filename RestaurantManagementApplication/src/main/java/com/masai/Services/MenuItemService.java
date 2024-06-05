package com.masai.Services;

import com.masai.model.MenuItem;

public interface MenuItemService {
	public MenuItem createMenuItem(MenuItem menuItem);
	public MenuItem deleteMenuItem(Long id);
}
