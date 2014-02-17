package com.thirdblock.migo.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.account.web.action.dto.RepositorySearchForm;
import com.thirdblock.migo.core.bo.Repository;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface RepositoryDao {

	void update(Repository repository);

	void save(Repository repository);

	List<Repository> searchRepositories(RepositorySearchForm form,
			@Param("page") PageBean<Repository> page);

}
