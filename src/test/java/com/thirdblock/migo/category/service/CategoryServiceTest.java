package com.thirdblock.migo.category.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.thirdblock.migo.category.web.action.dto.CategoryNode;
import com.thirdblock.migo.core.bo.Category;
import com.thirdblock.migo.test.SpringTransactionalIntegrationTestCase;

public class CategoryServiceTest extends SpringTransactionalIntegrationTestCase {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	@Rollback(false)
	public void buildCategoryBatch() throws IOException {
		
		FileReader fr = new FileReader("/Users/zhanghao/Desktop/category_data.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		Long rootParentId = 0L;
		Long parentId = 0L;
		
		Category c = new Category();
		c.setName(line);
		c.setParentId(rootParentId);
		categoryService.saveOrUpdate(c);
		rootParentId = c.getId();

		while ((line = br.readLine()) != null) {
			if ( StringUtils.isBlank(line) )
				continue;
			
			if ( StringUtils.startsWith(line, "    ")) {
				line = StringUtils.stripStart(line, "    ");
				
				String[] tokens = StringUtils.split(line, " ");
				
				for (String token : tokens) {
					Category category = new Category();
					category.setName(token);
					category.setParentId(parentId);
					categoryService.saveOrUpdate(category);
				}
				
			} else {
				
				Category category = new Category();
				category.setName(line);
				category.setParentId(rootParentId);
				categoryService.saveOrUpdate(category);
				parentId = category.getId();
				
			}
			

		}
		
		fr.close();
		
	}
	
	@Test
	public void testBuildCategoryTree() {
		CategoryNode root = categoryService.getCategoryTree();
		System.out.println(root);
	}
	
}
