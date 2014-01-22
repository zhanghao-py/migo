package com.thirdblock.migo.category.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.category.dao.CategoryDao;
import com.thirdblock.migo.category.service.CategoryService;
import com.thirdblock.migo.category.web.action.dto.CategoryNode;
import com.thirdblock.migo.core.bo.Category;
import com.thirdblock.migo.core.excep.ServiceException;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void saveOrUpdate(Category category) {
		
		if (ObjectUtils.equals(category.getId(), null)) {
			categoryDao.save(category);
		} else {
			categoryDao.update(category);
		}
	}

	@Override
	public Category findById(Long id) throws ServiceException {
		if (ObjectUtils.equals(id, null) || id.equals(0L)) {
			throw new ServiceException("id can't be null.");
		}
		
		return categoryDao.findById(id);
	}

	/**
	 * 获得分类树
	 * @return 根节点元素
	 */
	@Override
	public CategoryNode getCategoryTree() {
		List<Category> categories = categoryDao.list();
		return buildCategoryTree(categories);
	}
	
	/**
	 * 构造分类树
	 * @param categories
	 * @return 根节点元素
	 */
	private CategoryNode buildCategoryTree(List<Category> categories) {
		
		// parentId -> categories
		Map<Long, List<Category>> childrenSearcher = new HashMap<Long, List<Category>>();
		
		Iterator<Category> iter = categories.iterator();
		while (iter.hasNext()) {
			Category c = iter.next();
			
			Long parentId = c.getParentId();
			List<Category> lst = childrenSearcher.get(parentId);
			
			if (lst == null) {
				lst = new LinkedList<Category>();
				childrenSearcher.put(parentId, lst);
			}
			
			lst.add(c);
		}
		
		// 设置根节点
		CategoryNode root = new CategoryNode();
		Category category = new Category();
		category.setId(0L);
		category.setParentId(0L);
		category.setName(Category.ROOT);
		
		buildCategoryTree(root, category, childrenSearcher);
		
		return root;
	}
	
	@SuppressWarnings("unchecked")
	private void buildCategoryTree(CategoryNode node, Category category, Map<Long, List<Category>> childrenSearcher) {
		
		Long id = category.getId();
		List<Category> categories = childrenSearcher.get(id);
		categories = (List<Category>) ObjectUtils.defaultIfNull(categories, new ArrayList<Category>());
		
		List<CategoryNode> children = (List<CategoryNode>) CollectionUtils.collect(categories, new Transformer(){
			@Override
			public Object transform(Object object) {
				CategoryNode node = new CategoryNode();
				node.setCategory((Category) object);
				return node;
			}
		});
		
		// 构造当前节点
		node.setCategory(category);
		node.setChildren(children);
		
		// 构造孩子节点
		for (int i = 0; i < children.size(); i++) {
			CategoryNode child = children.get(i);
			Category c = categories.get(i);
			buildCategoryTree(child, c, childrenSearcher);
		}
		
		return;
	}

}
