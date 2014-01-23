package com.thirdblock.migo.account.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.MenuDao;
import com.thirdblock.migo.account.service.MenuService;
import com.thirdblock.migo.account.web.action.dto.MenuNode;
import com.thirdblock.migo.core.bo.Category;
import com.thirdblock.migo.core.bo.Menu;
import com.thirdblock.migo.core.web.action.dto.Visitor;

@Component
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public void saveOrUpdate(Menu menu) {
		if (ObjectUtils.equals(menu.getId(), null)) {
			menuDao.save(menu);
		} else {
			menuDao.update(menu);
		}
	}

	@Override
	public MenuNode getMenuTree(Visitor visitor) {
		List<Menu> menus = menuDao.list();
		return buildMenuTree(menus, visitor.getAuthorities());
	}

	private MenuNode buildMenuTree(List<Menu> menus, Collection<GrantedAuthority> authorities) {
		// parentId -> menus
		Map<Long, List<Menu>> childrenSearcher = new HashMap<Long, List<Menu>>();
		
		Iterator<Menu> iter = menus.iterator();
		while (iter.hasNext()) {
			Menu m = iter.next();
			final String auth = m.getAuth();
			
			boolean hasAuth = CollectionUtils.exists(authorities, new Predicate() {
				@Override
				public boolean evaluate(Object object) {
					return ((GrantedAuthority) object).getAuthority().equals(auth);
				}
			});
			
			if (!hasAuth) {
				continue;
			}
			
			Long parentId = m.getParentId();
			List<Menu> lst = childrenSearcher.get(parentId);
			
			if (lst == null) {
				lst = new LinkedList<Menu>();
				childrenSearcher.put(parentId, lst);
			}
			
			lst.add(m);
		}
		
		// 设置根节点
		MenuNode root = new MenuNode();
		Menu menu = new Menu();
		menu.setId(0L);
		menu.setParentId(0L);
		menu.setName(Category.ROOT);
		
		buildMenuTree(root, menu, childrenSearcher);
		
		return root;
	}

	@SuppressWarnings("unchecked")
	private void buildMenuTree(MenuNode node, Menu menu, Map<Long, List<Menu>> childrenSearcher) {
		
		Long id = menu.getId();
		List<Menu> menus = childrenSearcher.get(id);
		menus = (List<Menu>) ObjectUtils.defaultIfNull(menus, new ArrayList<Menu>());
		
		List<MenuNode> children = (List<MenuNode>) CollectionUtils.collect(menus, new Transformer(){
			@Override
			public Object transform(Object object) {
				MenuNode node = new MenuNode();
				node.setMenu((Menu) object);
				return node;
			}
		});
		
		// 构造当前节点
		node.setMenu(menu);
		node.setChildren(children);
		
		// 构造孩子节点
		for (int i = 0; i < children.size(); i++) {
			MenuNode child = children.get(i);
			Menu m = menus.get(i);
			buildMenuTree(child, m, childrenSearcher);
		}
		
		return;
	}

}
