package com.thirdblock.migo.category.service;

import com.thirdblock.migo.category.web.action.dto.CategoryNode;
import com.thirdblock.migo.core.bo.Category;
import com.thirdblock.migo.core.excep.ServiceException;

public interface CategoryService {

	void saveOrUpdate(Category category);
	
	Category findById(Long id) throws ServiceException;
	
	CategoryNode getCategoryTree();
	
}
