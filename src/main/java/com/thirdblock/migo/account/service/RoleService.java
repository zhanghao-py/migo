package com.thirdblock.migo.account.service;

import java.util.List;

import com.thirdblock.migo.core.bo.Role;
import com.thirdblock.migo.core.bo.User;

public interface RoleService {

	List<Role> findRolesByUser(User user);
	
	Role findRoleByName(String roleName);

	void addRole4User(String roleName, User user);
}
