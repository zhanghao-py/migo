package com.thirdblock.migo.account.dao;

import java.util.List;

import com.thirdblock.migo.core.bo.Menu;

public interface MenuDao {

	void save(Menu menu);

	void update(Menu menu);

	List<Menu> list();
}
