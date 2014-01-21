package com.thirdblock.migo.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.thirdblock.migo.account.dao.UserDao;
import com.thirdblock.migo.account.service.RoleService;
import com.thirdblock.migo.account.service.UserService;
import com.thirdblock.migo.core.bo.User;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public User findUserByUsername(String username) {
		Assert.notNull(username, "username can't be null.");
		return userDao.findUserByUsername(username);
	}

	@Override
	public Long save(User user) {
		Assert.notNull(user, "user can't be null.");
		userDao.save(user);
		return user.getId();
	}

//	private Long update(SysUser user) {
//		Assert.notNull(user, "user can't be null.");
//		userDao.update(user);
//		return user.getId();
//	}

	/*
	@Override
	public void addUserFromPassport(Long uid, String username) {
		Assert.notNull(uid, "uid can't be null.");
		Assert.notNull(username, "username can't be null.");
		
		SysUser user = new SysUser();
		user.setId(uid);
		user.setUsername(username);
		user.setEnabled(Boolean.TRUE);
		
		this.save(user);
		roleService.addRole4User(SysRole.Role.ROLE_USER.name(), user);
		
		return;
	}
	*/

	
}
