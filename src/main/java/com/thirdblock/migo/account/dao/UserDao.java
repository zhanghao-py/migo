package com.thirdblock.migo.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.account.web.action.dto.SearchUsersVO;
import com.thirdblock.migo.account.web.action.dto.UserSearchForm;
import com.thirdblock.migo.core.bo.User;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface UserDao {

	User findUserByUsername(String username);

	void save(User user);

	void update(User user);

	List<SearchUsersVO> searchUsers(UserSearchForm form, @Param("page") PageBean<SearchUsersVO> page);

}
