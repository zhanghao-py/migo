package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.UserCreateForm;
import com.thirdblock.migo.core.bo.User;
import com.thirdblock.migo.core.excep.ServiceException;

public interface UserService {

	User findUserByUsername(String username);

	void saveOrUpdateUser(UserCreateForm form) throws ServiceException;

	//void addUserFromPassport(Long uid, String username);
}
