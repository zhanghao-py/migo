package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.MenuNode;
import com.thirdblock.migo.core.bo.Menu;
import com.thirdblock.migo.core.web.action.dto.Visitor;

public interface MenuService {

	void saveOrUpdate(Menu menu);
	
	MenuNode getMenuTree(Visitor visitor);
}
