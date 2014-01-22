package com.thirdblock.migo.category.web.action.dto;

import java.util.List;

import com.thirdblock.migo.core.bo.Category;

public class CategoryNode {

	private Category category;
	private List<CategoryNode> children;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<CategoryNode> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryNode> children) {
		this.children = children;
	}

}
