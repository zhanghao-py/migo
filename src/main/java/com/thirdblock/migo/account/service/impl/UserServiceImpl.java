package com.thirdblock.migo.account.service.impl;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.thirdblock.migo.account.dao.UserDao;
import com.thirdblock.migo.account.service.RoleService;
import com.thirdblock.migo.account.service.UserService;
import com.thirdblock.migo.account.web.action.dto.UserCreateForm;
import com.thirdblock.migo.core.bo.Role;
import com.thirdblock.migo.core.bo.User;
import com.thirdblock.migo.core.excep.ServiceException;

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
	public void saveOrUpdateUser(UserCreateForm form) throws ServiceException {
		
		validateUserCreateForm(form);
		
		User user = new User(form);
		
		if (ObjectUtils.notEqual(form.getId(), null) && form.getId() > 0L) {
			user.setId(form.getId());
			userDao.update(user);
		} else {
			// tb_user
			userDao.save(user);
			// tb_user_role
			roleService.addRole4User(Role.ROLE_USER, user);
		}
		
		return;
	}

	private void validateUserCreateForm(UserCreateForm form) throws ServiceException {
		
		if (StringUtils.isBlank(form.getUsername())) {
			throw new ServiceException("用户名不能为空！");
		}
		
		if (StringUtils.isBlank(form.getPassword())) {
			throw new ServiceException("密码不能为空！");
		}
		
		if (ObjectUtils.equals(form.getRepositoryId(), null) || form.getRepositoryId() < 1L) {
			throw new ServiceException("用户组不能为空！");
		}
		return;
		
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
