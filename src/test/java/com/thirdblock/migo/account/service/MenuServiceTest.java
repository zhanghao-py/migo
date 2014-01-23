package com.thirdblock.migo.account.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.annotation.Rollback;

import com.thirdblock.migo.account.web.action.dto.MenuNode;
import com.thirdblock.migo.core.bo.Menu;
import com.thirdblock.migo.core.web.action.dto.Visitor;
import com.thirdblock.migo.test.SpringTransactionalIntegrationTestCase;

public class MenuServiceTest extends SpringTransactionalIntegrationTestCase {
	
	@Autowired
	private MenuService menuService;

	@Test
	@Rollback(false)
	public void buildMenuBatch() throws IOException {
		
		FileReader fr = new FileReader("/Users/zhanghao/Desktop/menu_data.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		Long parentId = 0L;
		
		while ((line = br.readLine()) != null) {
			if ( StringUtils.isBlank(line) )
				continue;
			
			if ( StringUtils.startsWith(line, "    ")) {
				line = StringUtils.stripStart(line, "    ");
				
				String[] tokens = StringUtils.split(line, " ");
				
				for (String token : tokens) {
					Menu menu = new Menu();
					menu.setName(token);
					menu.setParentId(parentId);
					menu.setAuth("ROLE_USER");
					menuService.saveOrUpdate(menu);
				}
				
			} else {
				
				Menu menu = new Menu();
				menu.setName(line);
				menu.setParentId(0L);
				menu.setAuth("ROLE_USER");
				menuService.saveOrUpdate(menu);
				parentId = menu.getId();
				
			}
			

		}
		
		fr.close();
		
	}
	
	@Test
	public void testBuildMenuTree() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		Visitor v = new Visitor();
		v.setAuthorities(authorities);
		
		MenuNode root = menuService.getMenuTree(v);
		System.out.println(root);
	}
}
