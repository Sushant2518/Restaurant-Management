package com.masai.Services;
import java.util.List;

import com.masai.model.Menu;



public interface MenuService {
	public Menu addMenu(Menu menu);

	public Menu deleteMenu(long id);

	public List<Menu> findAll();
}
