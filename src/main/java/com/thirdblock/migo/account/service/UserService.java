package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.SearchUsersVO;
import com.thirdblock.migo.account.web.action.dto.UserCreateForm;
import com.thirdblock.migo.account.web.action.dto.UserSearchForm;
import com.thirdblock.migo.core.bo.User;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface UserService {

	User findUserByUsername(String username);

	void saveOrUpdateUser(UserCreateForm form) throws ServiceException;

	PageBean<SearchUsersVO> searchUsers(UserSearchForm form) throws ServiceException;

	//void addUserFromPassport(Long uid, String username);
}
