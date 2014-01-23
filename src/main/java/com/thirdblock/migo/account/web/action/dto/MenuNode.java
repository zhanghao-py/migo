package com.thirdblock.migo.account.web.action.dto;

import java.util.List;

import com.thirdblock.migo.core.bo.Menu;

public class MenuNode {

	private Menu menu;
	private List<MenuNode> children;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<MenuNode> getChildren() {
		return children;
	}

	public void setChildren(List<MenuNode> children) {
		this.children = children;
	}

}
