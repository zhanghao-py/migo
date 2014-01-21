package com.thirdblock.migo.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.core.bo.Role;

public interface RoleDao {
	
	public List<Role> findRolesByUserId(@Param("userId") Long userId);

	public Role findRoleByName(@Param("roleName") String roleName);

}
