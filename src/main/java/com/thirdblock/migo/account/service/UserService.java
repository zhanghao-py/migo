package com.thirdblock.migo.account.service;

import com.thirdblock.migo.core.bo.User;

public interface UserService {

	User findUserByUsername(String username);

	Long save(User user);

	//void addUserFromPassport(Long uid, String username);
}
