package com.thirdblock.migo.category.dao;

import java.util.List;

import com.thirdblock.migo.core.bo.Category;

public interface CategoryDao {

	void save(Category category);

	void update(Category category);

	Category findById(Long id);

	List<Category> list();

}
