package com.thirdblock.migo.account.dao;

import com.thirdblock.migo.core.bo.User;

public interface UserDao {

	User findUserByUsername(String username);

	void save(User user);

	void update(User user);

}
