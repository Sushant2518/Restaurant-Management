package com.masai.Services;

import com.masai.model.Tables;

public interface TablesService {
	public Tables createTable(Tables tables);

	public Tables deleteTable(long id);
}
